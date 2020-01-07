package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 群简介
 */
@Data
public class GroupName {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private Long groupId;
    /**
     * 群名称
     */
    @JsonProperty("group_name")
    private String groupName;
}
