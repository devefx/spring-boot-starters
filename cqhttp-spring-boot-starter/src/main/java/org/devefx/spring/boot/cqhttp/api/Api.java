package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import okhttp3.Request;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface Api<T> {
    SnakeCaseStrategy SNAKE_CASE_STRATEGY = new SnakeCaseStrategy();

    /**
     * 请求地址
     */
    default String url() {
        return SNAKE_CASE_STRATEGY.translate(this.getClass().getSimpleName());
    }
    /**
     * 请求方式
     */
    String method();
    /**
     * 响应数据类型
     */
    default Type responseType() {
        final Type[] genericInterfaces = this.getClass().getGenericInterfaces();
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                final ParameterizedType pt = (ParameterizedType) type;
                if (Api.class.isAssignableFrom((Class<?>) pt.getRawType())) {
                    return pt.getActualTypeArguments()[0];
                }
            }
        }
        return Void.TYPE;
    }
    /**
     * 处理请求
     * @param request 请求实例
     * @param mapper 序列器
     */
    default Request process(Request request, ObjectMapper mapper) {
        return request;
    }
}
