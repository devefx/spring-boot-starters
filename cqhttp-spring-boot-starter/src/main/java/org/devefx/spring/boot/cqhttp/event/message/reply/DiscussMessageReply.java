package org.devefx.spring.boot.cqhttp.event.message.reply;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DiscussMessageReply extends PrivateMessageReply {

    /**
     * 是否要在回复开头 at 发送者（自动添加）
     */
    private boolean atSender;
}
