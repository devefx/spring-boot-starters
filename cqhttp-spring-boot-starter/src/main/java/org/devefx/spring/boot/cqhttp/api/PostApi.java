package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface PostApi<T> extends Api<T> {
    @Override
    default String method() {
        return "POST";
    }

    @Override
    default Request process(Request request, ObjectMapper mapper) {
        try {
            final String value = mapper.writeValueAsString(this);
            final RequestBody body =  RequestBody.create(MediaType.parse(APPLICATION_JSON_VALUE), value);
            return request.newBuilder().post(body).build();
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("cannot serialization to json string", e);
        }
    }
}
