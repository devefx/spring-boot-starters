package org.devefx.spring.boot.cqhttp.event.message.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.devefx.spring.boot.cqhttp.types.Message;

@Data
public class PrivateMessageReply {
    /**
     * 要回复的内容
     */
    private Message reply;

    /**
     * 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 reply 字段是字符串时有效
     */
    @JsonProperty("auto_escape")
    private boolean autoEscape;

    public static PrivateMessageReply reply(Message message, boolean autoEscape) {
        final PrivateMessageReply reply = new PrivateMessageReply();
        reply.setReply(message);
        reply.setAutoEscape(autoEscape);
        return reply;
    }

    public static PrivateMessageReply reply(Message message) {
        return reply(message, false);
    }
}
