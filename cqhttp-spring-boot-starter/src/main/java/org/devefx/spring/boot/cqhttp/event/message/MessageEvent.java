package org.devefx.spring.boot.cqhttp.event.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.types.Message;
import org.devefx.spring.boot.cqhttp.event.Event;
import org.devefx.spring.boot.cqhttp.enums.MessageType;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "message_type", visible = true)
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "private", value = PrivateMessageEvent.class),
        @JsonSubTypes.Type(name = "group", value = GroupMessageEvent.class),
        @JsonSubTypes.Type(name = "discuss", value = DiscussMessageEvent.class)
})
public abstract class MessageEvent<T> extends Event<T> {
    /**
     * 消息类型
     */
    @JsonProperty("message_type")
    private MessageType messageType;

    /**
     * 消息 ID
     */
    @JsonProperty("message_id")
    private Integer messageId;

    /**
     * 发送者 QQ 号
     */
    @JsonProperty("user_id")
    private Long userId;

    /**
     * 消息内容
     */
    //private Object message;
    private Message message;

    /**
     * 原始消息内容
     */
    @JsonProperty("raw_message")
    private String rawMessage;

    /**
     * 字体
     */
    private Integer font;
}
