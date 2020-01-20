package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.resp.MessageId;
import org.devefx.spring.boot.cqhttp.types.Message;

import javax.validation.constraints.NotNull;

/**
 * 发送讨论组消息
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SendDiscussMsg implements PostApi<MessageId> {
    /**
     * 讨论组 ID（正常情况下看不到，需要从讨论组消息上报的数据中获得）
     */
    @JsonProperty("discuss_id")
    @NotNull
    private final Long discussId;
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
