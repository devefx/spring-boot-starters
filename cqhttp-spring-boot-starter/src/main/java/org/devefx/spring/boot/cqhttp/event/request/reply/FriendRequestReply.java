package org.devefx.spring.boot.cqhttp.event.request.reply;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class FriendRequestReply {
    private static final FriendRequestReply DISAPPROVED = new FriendRequestReply(false);
    /**
     * 是否同意请求
     */
    private final boolean approve;

    /**
     * 添加后的好友备注
     */
    private String remark;

    /**
     * 同意请求
     * @param remark 好友备注
     */
    public static FriendRequestReply approved(String remark) {
        return new FriendRequestReply(true, remark);
    }

    /**
     * 拒绝请求
     */
    public static FriendRequestReply disapproved() {
        return DISAPPROVED;
    }
}
