package org.devefx.spring.boot.cqhttp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 消息类型
 */
public enum MessageType {
    /**
     * 私聊消息
     */
    PRIVATE,
    /**
     * 群消息
     */
    GROUP,
    /**
     * 讨论组消息
     */
    DISCUSS;

    @JsonCreator
    public static MessageType from(String name) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
    }

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }
}
