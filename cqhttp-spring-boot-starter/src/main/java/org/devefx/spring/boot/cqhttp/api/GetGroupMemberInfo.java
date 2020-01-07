package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.resp.GroupMemberInfo;

/**
 * 获取群成员信息
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetGroupMemberInfo implements GetApi<GroupMemberInfo> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private final Long groupId;
    /**
     * QQ 号
     */
    @JsonProperty("user_id")
    private final Long userId;
    /**
     * 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     */
    @JsonProperty("no_cache")
    private boolean noCache;
}
