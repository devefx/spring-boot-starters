package org.devefx.spring.boot.cqhttp.event.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.event.request.reply.GroupRequestReply;

import java.util.Arrays;

/**
 * 加群请求／邀请
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupRequestEvent extends RequestEvent<GroupRequestReply> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private Long groupId;

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
         * 加群请求
         */
        ADD,
        /**
         * 邀请登录号入群
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
