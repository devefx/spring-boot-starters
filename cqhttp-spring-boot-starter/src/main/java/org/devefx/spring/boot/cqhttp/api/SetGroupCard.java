package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 设置群名片（群备注）
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupCard implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private final Long groupId;
    /**
     * 要设置的 QQ 号
     */
    @JsonProperty("user_id")
    private final Long userId;
    /**
     * 群名片内容，不填或空字符串表示删除群名片
     */
    private String card;
}
