package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import static org.devefx.spring.boot.cqhttp.event.request.GroupRequestEvent.SubType;

/**
 * 处理加群请求／邀请
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupAddRequest implements PostApi<Void> {
    /**
     * 加群请求的 flag（需从上报的数据中获得）
     */
    private final String flag;
    /**
     * 请求类型（需要和上报消息中的 sub_type 字段相符）
     */
    @JsonProperty("sub_type")
    private final SubType subType;
    /**
     * 是否同意请求／邀请
     */
    private boolean approve = true;
    /**
     * 拒绝理由（仅在拒绝时有效）
     */
    private String reason;
}
