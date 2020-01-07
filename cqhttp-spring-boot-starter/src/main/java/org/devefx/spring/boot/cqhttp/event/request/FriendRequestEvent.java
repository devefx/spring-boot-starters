package org.devefx.spring.boot.cqhttp.event.request;

import lombok.ToString;
import org.devefx.spring.boot.cqhttp.event.request.reply.FriendRequestReply;

/**
 * 加好友请求
 */
@ToString(callSuper = true)
public class FriendRequestEvent extends RequestEvent<FriendRequestReply> {
}
