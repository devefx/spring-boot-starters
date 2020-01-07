package org.devefx.spring.boot.cqhttp.listener;

import org.devefx.spring.boot.cqhttp.event.Event;

public interface EventListener<Reply, E extends Event<Reply>> {

    Reply onEvent(E event);

}
