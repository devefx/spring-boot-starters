package org.devefx.spring.boot.cqhttp.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 重启 HTTP API 插件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetRestartPlugin implements PostApi<Void> {
    /**
     * 要延迟的毫秒数，如果默认情况下无法重启，可以尝试设置延迟为 2000 左右
     */
    private long delay;
}
