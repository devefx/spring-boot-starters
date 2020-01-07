package org.devefx.spring.boot.cqhttp.event.message.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GroupMessageReply extends PrivateMessageReply {

    /**
     * 是否要在回复开头 at 发送者（自动添加），发送者是匿名用户时无效
     */
    @JsonProperty("at_sender")
    private boolean atSender;

    /**
     * 撤回该条消息
     */
    private boolean delete;

    /**
     * 把发送者踢出群组（需要登录号权限足够），不拒绝此人后续加群请求，
     * 发送者是匿名用户时无效
     */
    private boolean kick;

    /**
     * 把发送者禁言 {@link #banDuration} 指定时长，对匿名用户也有效
     */
    private boolean ban;

    /**
     * 禁言时长，默认 30 分钟（单位：分钟）
     */
    @JsonProperty("ban_duration")
    private Integer banDuration;

}
