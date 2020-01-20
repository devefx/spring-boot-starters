package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.util.Map;
import java.util.Objects;

public interface GetApi<T> extends Api<T> {
    @Override
    default String method() {
        return "GET";
    }

    @Override
    default Request process(Request request, ObjectMapper mapper) {
        final Map<String, Object> params = mapper.convertValue(this, new TypeReference<Map<String, Object>>() {});
        final HttpUrl.Builder builder = request.url().newBuilder();
        params.entrySet().stream().filter(e -> Objects.nonNull(e.getValue())).forEach(entry ->
                builder.addQueryParameter(entry.getKey(), String.valueOf(entry.getValue())));
        return request.newBuilder().url(builder.build()).build();
    }
}
