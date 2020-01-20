package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.devefx.spring.boot.cqhttp.api.resp.GroupMemberInfo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 获取群成员列表
 */
@Data
public class GetGroupMemberList implements GetApi<List<GroupMemberInfo>> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    @NotNull
    private final Long groupId;
}
