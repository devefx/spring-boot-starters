package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.resp.StrangerInfo;

import javax.validation.constraints.NotNull;

/**
 * 获取陌生人信息
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetStrangerInfo implements GetApi<StrangerInfo> {
    /**
     * QQ 号
     */
    @JsonProperty("user_id")
    @NotNull
    private final Long userId;
    /**
     * 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     */
    @JsonProperty("no_cache")
    private boolean noCache;
}
