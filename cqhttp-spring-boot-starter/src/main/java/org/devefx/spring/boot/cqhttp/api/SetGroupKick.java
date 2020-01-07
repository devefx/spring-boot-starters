package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 群组踢人
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupKick implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    @NotNull
    private final Long groupId;
    /**
     * 要踢的 QQ 号
     */
    @JsonProperty("user_id")
    @NotNull
    private final Long userId;
    /**
     * 拒绝此人的加群请求
     */
    @JsonProperty("reject_add_request")
    private boolean rejectAddRequest;
}
