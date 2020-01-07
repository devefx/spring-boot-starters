package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.resp.MessageId;
import org.devefx.spring.boot.cqhttp.domain.entity.Message;

import javax.validation.constraints.NotNull;

/**
 * 发送私聊消息
 */
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class SendPrivateMsg implements PostApi<MessageId> {
    /**
     * 对方 QQ 号
     */
    @JsonProperty("user_id")
    @NotNull
    private final Long userId;
    /**
     * 要发送的内容
     */
    @NotNull
    private final Message message;
    /**
     * 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     */
    @JsonProperty("auto_escape")
    private boolean autoEscape;
}
