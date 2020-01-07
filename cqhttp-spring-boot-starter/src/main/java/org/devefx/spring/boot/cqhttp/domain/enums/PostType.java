package org.devefx.spring.boot.cqhttp.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 上报类型
 */
public enum PostType {
    /**
     * 收到消息
     */
    MESSAGE,
    /**
     * 群、讨论组变动等通知类事件
     */
    NOTICE,
    /**
     * 加好友请求、加群请求／邀请
     */
    REQUEST;

    @JsonCreator
    public static PostType from(String name) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
    }

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }
}
