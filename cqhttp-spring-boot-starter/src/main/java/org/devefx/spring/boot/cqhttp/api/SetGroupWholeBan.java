package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupWholeBan implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private final Long groupId;
    /**
     * 是否禁言
     */
    private boolean enable;
}
