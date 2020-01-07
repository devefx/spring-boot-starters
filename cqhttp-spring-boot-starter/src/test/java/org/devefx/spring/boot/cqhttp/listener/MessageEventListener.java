package org.devefx.spring.boot.cqhttp.listener;

import org.devefx.spring.boot.cqhttp.event.message.MessageEvent;
import org.devefx.spring.boot.cqhttp.event.message.reply.PrivateMessageReply;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(100)
@Component
public class MessageEventListener implements EventListener<List<Object>, MessageEvent<List<Object>>> {

    @Override
    public List<Object> onEvent(MessageEvent<List<Object>> event) {
        System.out.println(event);
        return null;
    }
}
