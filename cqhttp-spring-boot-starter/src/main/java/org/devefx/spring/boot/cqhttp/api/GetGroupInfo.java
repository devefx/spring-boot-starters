package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.resp.GroupInfo;

import javax.validation.constraints.NotNull;

/**
 * 获取群列表
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetGroupInfo implements GetApi<GroupInfo> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    @NotNull
    private final Long groupId;
    /**
     * 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     */
    @JsonProperty("no_cache")
    private boolean noCache;
}
