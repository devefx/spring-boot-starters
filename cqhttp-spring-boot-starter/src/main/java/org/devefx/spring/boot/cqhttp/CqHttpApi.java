package org.devefx.spring.boot.cqhttp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.devefx.spring.boot.cqhttp.api.Api;
import org.devefx.spring.boot.cqhttp.api.ApiExecutor;
import org.devefx.spring.boot.cqhttp.api.resp.ApiResp;
import org.devefx.spring.boot.cqhttp.exception.ApiRequestException;
import org.devefx.spring.boot.cqhttp.exception.ApiStatusException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.Set;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CqHttpApi implements ApiExecutor {
    private final String host;
    private final int port;
    private final String accessToken;
    private final OkHttpClient client;
    private final Validator validator;
    private final ObjectMapper mapper;

    @Override
    public <T extends Api<R>, R> R execute(T method) {
        validateParams(method);

        final Request request = newRequest(method);
        try {
            final Response response = client.newCall(request).execute();
            return readValue(response, method.responseType());
        } catch (IOException e) {
            throw new IllegalStateException("call failed: " + request, e);
        }
    }

    private void validateParams(Api<?> api) {
        final Set<ConstraintViolation<Object>> result = validator.validate(api);
        if (!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }
    }

    private Request newRequest(Api<?> api) {
        final Request.Builder builder = new Request.Builder();
        if (accessToken != null) {
            builder.addHeader(AUTHORIZATION, "Bearer " + accessToken);
        }
        builder.url(new HttpUrl.Builder().scheme("http").host(host).port(port)
                .addPathSegment(api.url()).build());
        return api.process(builder.build(), mapper);
    }

    private <T> T readValue(Response response, Type type) {
        if (!response.isSuccessful()) {
            throw new ApiStatusException(response.code(), response.message());
        }
        final ResponseBody body = response.body();
        if (body != null) {
            final TypeFactory typeFactory = mapper.getTypeFactory();
            try {
                final ApiResp<T> apiResp = mapper.readValue(body.bytes(),
                        typeFactory.constructParametricType(ApiResp.class, typeFactory.constructType(type)));
                if (apiResp.isOk()) {
                    return apiResp.getData();
                }
                throw new ApiRequestException(apiResp.getStatus(), apiResp.getCode());
            } catch (IOException e) {
                throw new IllegalStateException("cannot read response body", e);
            }
        }
        throw new IllegalStateException("response body is null");
    }

    public static class Builder {
        private String host = "localhost";
        private int port = 5700;
        private String accessToken;
        private OkHttpClient client;
        private Validator validator;
        private ObjectMapper mapper;

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder client(OkHttpClient client) {
            this.client = client;
            return this;
        }

        public Builder validator(Validator validator) {
            this.validator = validator;
            return this;
        }

        public Builder mapper(ObjectMapper mapper) {
            this.mapper = mapper;
            return this;
        }

        private static OkHttpClient defaultClient() {
            return new OkHttpClient.Builder().build();
        }

        private static Validator defaultValidator() {
            return Validation.buildDefaultValidatorFactory().getValidator();
        }

        private static ObjectMapper defaultMapper() {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
            return mapper;
        }

        public CqHttpApi build() {
            return new CqHttpApi(host, port, accessToken,
                    Optional.ofNullable(client).orElseGet(Builder::defaultClient),
                    Optional.ofNullable(validator).orElseGet(Builder::defaultValidator),
                    Optional.ofNullable(mapper).orElseGet(Builder::defaultMapper));
        }
    }
}
