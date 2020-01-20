package org.devefx.spring.boot.cqhttp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 通知类型
 */
public enum NoticeType {
    /**
     * 群文件上传
     */
    GROUP_UPLOAD,
    /**
     * 群管理员变动
     */
    GROUP_ADMIN,
    /**
     * 群成员减少
     */
    GROUP_DECREASE,
    /**
     * 群成员增加
     */
    GROUP_INCREASE,
    /**
     * 群禁言
     */
    GROUP_BAN,
    /**
     * 好友添加
     */
    FRIEND_ADD;

    @JsonCreator
    public static NoticeType from(String name) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
    }

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }
}
