package org.devefx.spring.boot.cqhttp.api;

public interface GetApi<T> extends Api<T> {
    @Override
    default String method() {
        return "GET";
    }
}
