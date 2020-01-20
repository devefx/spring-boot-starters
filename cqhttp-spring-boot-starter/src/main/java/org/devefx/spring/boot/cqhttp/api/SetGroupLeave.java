package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 退出群组
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupLeave implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    @NotNull
    private final Long groupId;
    /**
     * 是否解散，如果登录号是群主，则仅在此项为 true 时能够解散
     */
    @JsonProperty("is_dismiss")
    private boolean dismiss;
}
