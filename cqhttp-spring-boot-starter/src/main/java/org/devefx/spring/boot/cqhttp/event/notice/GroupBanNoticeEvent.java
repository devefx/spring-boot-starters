package org.devefx.spring.boot.cqhttp.event.notice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;

/**
 * 群禁言
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupBanNoticeEvent extends NoticeEvent {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private Long groupId;

    /**
     * 操作者 QQ 号
     */
    @JsonProperty("operator_id")
    private Long operatorId;

    /**
     * 禁言时长，单位秒
     */
    private Long duration;

    /**
     * 事件子类型
     */
    @JsonProperty("sub_type")
    private SubType subType;

    /**
     * 事件子类型
     */
    public enum SubType {
        /**
         * 禁言
         */
        BAN,
        /**
         * 解除禁言
         */
        LIFT_BAN;

        @JsonCreator
        public static SubType from(String name) {
            return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
        }

        @JsonValue
        public String getValue() {
            return name().toLowerCase();
        }
    }
}
