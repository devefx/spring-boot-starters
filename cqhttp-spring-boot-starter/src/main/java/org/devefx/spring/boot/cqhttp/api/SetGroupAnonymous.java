package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 群组匿名
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupAnonymous implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private final Long groupId;
    /**
     * 是否允许匿名聊天
     */
    private boolean enable;
}
