package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageId {
    /**
     * 消息 ID
     */
    @JsonProperty("message_id")
    private Long messageId;
}
