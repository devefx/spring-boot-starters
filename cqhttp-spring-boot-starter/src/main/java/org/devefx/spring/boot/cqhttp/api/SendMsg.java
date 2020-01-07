package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.devefx.spring.boot.cqhttp.api.resp.MessageId;
import org.devefx.spring.boot.cqhttp.domain.entity.Message;
import org.devefx.spring.boot.cqhttp.domain.enums.MessageType;

import javax.validation.constraints.NotNull;

@Data
public class SendMsg implements PostApi<MessageId> {
    /**
     * 消息类型，如不传入，则根据传入的 *_id 参数判断
     */
    @JsonProperty("message_type")
    private MessageType message_type;
    /**
     * 对方 QQ 号（消息类型为 private 时需要）
     */
    @JsonProperty("user_id")
    @NotNull
    private Long userId;
    /**
     * 群号（消息类型为 group 时需要）
     */
    @JsonProperty("group_id")
    @NotNull
    private Long groupId;
    /**
     * 讨论组 ID（消息类型为 discuss 时需要）
     */
    @JsonProperty("discuss_id")
    @NotNull
    private Long discussId;
    /**
     * 要发送的内容
     */
    @NotNull
    private final Message message;
    /**
     * 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     */
    @NotNull
    @JsonProperty("auto_escape")
    private boolean autoEscape;
}
