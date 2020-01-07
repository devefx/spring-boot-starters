package org.devefx.spring.boot.cqhttp.event.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.domain.enums.MetaEventType;
import org.devefx.spring.boot.cqhttp.event.Event;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class MetaEvent extends Event<Void> {
    /**
     * 元事件类型
     */
    @JsonProperty("meta_event_type")
    private MetaEventType metaEventType;
}
