package org.devefx.spring.boot.cqhttp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 性别
 */
public enum Sex {
    /**
     * 男
     */
    MALE,
    /**
     * 女
     */
    FEMALE,
    /**
     * 未知
     */
    UNKNOWN;

    @JsonCreator
    public static Sex from(String name) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
    }

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }
}
