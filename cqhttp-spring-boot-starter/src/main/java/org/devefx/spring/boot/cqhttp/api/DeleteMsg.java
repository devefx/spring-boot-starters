package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 撤回消息
 */
@Data
public class DeleteMsg implements PostApi<Void> {
    /**
     * 消息 ID
     */
    @JsonProperty("message_id")
    @NotNull
    private final Long messageId;
}
