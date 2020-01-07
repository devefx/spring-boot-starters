package org.devefx.spring.boot.cqhttp.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devefx.spring.boot.cqhttp.event.Event;
import org.springframework.util.ClassUtils;

@Slf4j
@RequiredArgsConstructor
public class EventListenerHandler {
    private final EventListener<?, Event<?>> listener;
    private final Class<?> eventClass;

    public Object handle(Event<?> event) {
        if (ClassUtils.isAssignable(eventClass, event.getClass())) {
            try {
                return listener.onEvent(event);
            } catch (Exception e) {
                log.error("Failed to invoke event listener, details: \n" +
                        "Bean [{}]\n" + "Event [{}]",  listener, event, e);
            }
        }
        return null;
    }
}
