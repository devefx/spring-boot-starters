package org.devefx.spring.boot.cqhttp.event.meta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;

/**
 * 生命周期
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LifecycleMetaEvent extends MetaEvent {
    /**
     * 事件子类型
     */
    @JsonProperty("sub_type")
    private SubType subType;

    /**
     * 事件子类型
     */
    public enum SubType {
        /**
         * 插件启用
         */
        enable,
        /**
         * 插件停用
         */
        disable;

        @JsonCreator
        public static SubType from(String name) {
            return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
        }

        @JsonValue
        public String getValue() {
            return name().toLowerCase();
        }
    }
}
