package org.devefx.spring.boot.cqhttp.event.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.types.Anonymous;
import org.devefx.spring.boot.cqhttp.types.GroupSender;
import org.devefx.spring.boot.cqhttp.event.message.reply.GroupMessageReply;

import java.util.Arrays;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupMessageEvent extends MessageEvent<GroupMessageReply> {
    /**
     * 消息子类型
     */
    @JsonProperty("sub_type")
    private SubType subType;

    /**
     * 群号
     */
    @JsonProperty("group_id")
    private Long groupId;

    /**
     * 匿名信息，如果不是匿名消息则为 null
     */
    private Anonymous anonymous;

    /**
     * 发送人信息
     */
    private GroupSender sender;

    /**
     * 消息子类型
     */
    public enum SubType {
        /**
         * 正常消息
         */
        NORMAL,
        /**
         * 匿名消息
         */
        ANONYMOUS,
        /**
         * 系统提示
         */
        NOTICE;

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
