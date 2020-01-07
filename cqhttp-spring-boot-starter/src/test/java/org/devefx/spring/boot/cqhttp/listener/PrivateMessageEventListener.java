package org.devefx.spring.boot.cqhttp.listener;

import org.devefx.spring.boot.cqhttp.domain.entity.EncodeMessage;
import org.devefx.spring.boot.cqhttp.event.message.PrivateMessageEvent;
import org.devefx.spring.boot.cqhttp.event.message.reply.PrivateMessageReply;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(150)
@Component
public class PrivateMessageEventListener implements EventListener<PrivateMessageReply, PrivateMessageEvent> {

    @Override
    public PrivateMessageReply onEvent(PrivateMessageEvent event) {
        return PrivateMessageReply.reply(new EncodeMessage("你发的消息是：" + event.getRawMessage()));
    }
}
