package org.devefx.spring.boot.cqhttp.event.meta;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.api.resp.PluginStatus;

/**
 * 心跳
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class HeartbeatMetaEvent extends MetaEvent {
    /**
     * 状态信息
     */
    private PluginStatus status;
    /**
     * 到下次心跳的间隔，单位毫秒
     */
    private Long interval;
}
