package org.devefx.spring.boot.cqhttp.api;

public interface PostApi<T> extends Api<T> {
    @Override
    default String method() {
        return "POST";
    }
}
