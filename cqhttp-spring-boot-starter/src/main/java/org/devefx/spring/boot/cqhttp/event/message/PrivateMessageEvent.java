package org.devefx.spring.boot.cqhttp.event.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.domain.entity.Sender;
import org.devefx.spring.boot.cqhttp.event.message.reply.PrivateMessageReply;

import java.util.Arrays;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PrivateMessageEvent extends MessageEvent<PrivateMessageReply> {
    /**
     * 消息子类型
     */
    @JsonProperty("sub_type")
    private SubType subType;

    /**
     * 发送人信息
     */
    private Sender sender;

    /**
     * 消息子类型，如果是好友则是 FRIEND，如果从群或讨论组来的临时
     * 会话则分别是 GROUP、DISCUSS
     */
    public enum SubType {
        /**
         * 好友消息
         */
        FRIEND,
        /**
         * 群临时消息
         */
        GROUP,
        /**
         * 讨论组临时消息
         */
        DISCUSS,
        /**
         * 其他
         */
        OTHER;

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
