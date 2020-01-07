package org.devefx.spring.boot.cqhttp.event.request.reply;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class GroupRequestReply {
    private static final GroupRequestReply APPROVED = new GroupRequestReply(true);
    /**
     * 是否同意请求／邀请
     */
    private final boolean approve;
    /**
     * 拒绝理由（仅在拒绝时有效）
     */
    private String reason;

    /**
     * 同意
     */
    public static GroupRequestReply approved() {
        return APPROVED;
    }

    /**
     * 拒绝
     * @param reason 拒绝理由
     */
    public static GroupRequestReply disapproved(String reason) {
        return new GroupRequestReply(false, reason);
    }
}
