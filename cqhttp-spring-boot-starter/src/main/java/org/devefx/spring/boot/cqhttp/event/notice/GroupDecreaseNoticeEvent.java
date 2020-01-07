package org.devefx.spring.boot.cqhttp.event.notice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;

/**
 * 群成员减少
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupDecreaseNoticeEvent extends NoticeEvent {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private Long groupId;

    /**
     * 操作者 QQ 号（如果是主动退群，则和 user_id 相同）
     */
    @JsonProperty("operator_id")
    private Long operatorId;

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
         * 主动退群
         */
        LEAVE,
        /**
         * 成员被踢
         */
        KICK,
        /**
         * 登录号被踢
         */
        KICK_ME;

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
