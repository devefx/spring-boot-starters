package org.devefx.spring.boot.cqhttp.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 角色
 */
public enum Role {
    /**
     * 群主
     */
    OWNER,
    /**
     * 管理员
     */
    ADMIN,
    /**
     * 成员
     */
    MEMBER;

    @JsonCreator
    public static Role from(String name) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
    }

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }
}
