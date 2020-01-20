package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 退出讨论组
 */
@Data
public class SetDiscussLeave implements PostApi<Void> {
    /**
     * 讨论组 ID（正常情况下看不到，需要从讨论组消息上报的数据中获得）
     */
    @JsonProperty("discuss_id")
    @NotNull
    private final Long discussId;
}
