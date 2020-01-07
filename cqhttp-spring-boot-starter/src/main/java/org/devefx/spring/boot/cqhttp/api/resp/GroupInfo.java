package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 群信息
 */
@Data
public class GroupInfo {
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
    /**
     * 成员数
     */
    @JsonProperty("member_count")
    private Integer memberCount;
    /**
     * 最大成员数（群容量）
     */
    @JsonProperty("max_member_count")
    private Integer maxMemberCount;
}
