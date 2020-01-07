package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 群组设置管理员
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupAdmin implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private final Long groupId;
    /**
     * 要设置管理员的 QQ 号
     */
    @JsonProperty("user_id")
    private final Long userId;
    /**
     * true 为设置，false 为取消
     */
    private boolean enable;
}
