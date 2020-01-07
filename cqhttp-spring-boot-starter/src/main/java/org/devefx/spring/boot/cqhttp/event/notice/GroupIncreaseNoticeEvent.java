package org.devefx.spring.boot.cqhttp.event.notice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;

/**
 * 群成员增加
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupIncreaseNoticeEvent extends NoticeEvent {
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
     * 事件子类型
     */
    @JsonProperty("sub_type")
    private SubType subType;

    /**
     * 事件子类型
     */
    public enum SubType {
        /**
         * 管理员已同意入群
         */
        APPROVE,
        /**
         * 管理员邀请入群
         */
        INVITE;

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
