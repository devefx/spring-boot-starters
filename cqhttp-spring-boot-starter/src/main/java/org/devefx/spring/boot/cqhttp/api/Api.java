package org.devefx.spring.boot.cqhttp.api;

public interface Api<T> {
    /**
     * 请求地址
     */
    default String url() {
        // TODO
        return this.getClass().getSimpleName();
    }
    /**
     * 请求方式
     */
    String method();
}
