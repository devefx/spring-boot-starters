package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 撤回消息
 */
@Data
public class DeleteMsg implements PostApi<Void> {
    /**
     * 消息 ID
     */
    @JsonProperty("message_id")
    private final Long messageId;
}
