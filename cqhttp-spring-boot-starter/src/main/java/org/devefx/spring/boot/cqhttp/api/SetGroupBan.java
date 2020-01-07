package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 群组单人禁言
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupBan implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    @NotNull
    private final Long groupId;
    /**
     * 要禁言的 QQ 号
     */
    @JsonProperty("user_id")
    @NotNull
    private final Long userId;
    /**
     * 禁言时长，单位秒，0 表示取消禁言
     */
    private Integer duration = 30 * 60;
}
