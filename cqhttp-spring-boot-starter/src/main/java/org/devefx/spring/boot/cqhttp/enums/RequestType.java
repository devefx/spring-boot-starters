package org.devefx.spring.boot.cqhttp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 请求类型
 */
public enum RequestType {
    /**
     * 加好友请求
     */
    friend,
    /**
     * 加群请求／邀请
     */
    group;

    @JsonCreator
    public static RequestType from(String name) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
    }

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }
}
