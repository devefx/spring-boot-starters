package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.resp.MessageId;
import org.devefx.spring.boot.cqhttp.domain.entity.Message;

import javax.validation.constraints.NotNull;

/**
 * 发送群消息
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SendGroupMsg implements PostApi<MessageId> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    @NotNull
    private final Long groupId;
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
