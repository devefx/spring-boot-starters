package org.devefx.spring.boot.cqhttp.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 处理加好友请求
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetFriendAddRequest implements PostApi<Void> {
    /**
     * 加好友请求的 flag（需从上报的数据中获得）
     */
    private final String flag;
    /**
     * 是否同意请求
     */
    private boolean approve = true;
    /**
     * 添加后的好友备注（仅在同意时有效）
     */
    private String remark;
}
