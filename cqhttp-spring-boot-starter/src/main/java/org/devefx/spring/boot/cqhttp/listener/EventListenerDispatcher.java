package org.devefx.spring.boot.cqhttp.listener;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devefx.spring.boot.cqhttp.event.Event;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class EventListenerDispatcher implements InitializingBean {
    private final Set<EventListenerHandler> handlers = new LinkedHashSet<>();
    private final ApplicationContext applicationContext;
    private boolean publishEventToSpring = true;

    public Object doEvent(Event<?> event) {
        if (this.publishEventToSpring) {
            publishEventToSpring(event);
        }
        return this.handlers.stream().map(it -> it.handle(event))
                .filter(Objects::nonNull).findFirst().orElse(null);
    }

    private void publishEventToSpring(Event<?> event) {
        try {
            this.applicationContext.publishEvent(event);
        } catch (Exception e) {
            log.error("Failed publish event to spring", e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void afterPropertiesSet() {
        final Map<String, EventListener> beans = applicationContext.getBeansOfType(EventListener.class);
        final List<EventListener> listeners = new ArrayList<>(beans.values());
        AnnotationAwareOrderComparator.sort(listeners);

        for (EventListener listener : listeners) {
            final Type[] interfaces = listener.getClass().getGenericInterfaces();

            final ParameterizedType type = (ParameterizedType) Arrays.stream(interfaces).filter(it -> {
                if (it instanceof ParameterizedType) {
                    return ((ParameterizedType) it).getRawType() instanceof EventListener;
                }
                return false;
            }).findFirst().orElse(interfaces[0]);

            final Type argumentType = type.getActualTypeArguments()[1];
            if (argumentType instanceof ParameterizedType) {
                handlers.add(new EventListenerHandler(listener, (Class<?>) ((ParameterizedType) argumentType).getRawType()));
            } else if (argumentType instanceof Class<?>) {
                handlers.add(new EventListenerHandler(listener, (Class<?>) argumentType));
            }
        }
    }
}
