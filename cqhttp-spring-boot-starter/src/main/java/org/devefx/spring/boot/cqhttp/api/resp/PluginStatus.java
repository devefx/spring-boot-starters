package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 插件运行状态
 *
 * 通常情况下建议只使用 {@link #online} 和 {@link #good} 这两个字段来判断运行状态，因为随着插件的更新，其它字段有可能频繁变化。
 * 其中，{@link #good} 字段的在线状态检测有两种方式，可通过 online_status_detection_method 配置项切换，
 * 默认通过读取 酷Q 日志数据库实现，可切换为 get_stranger_info 以通过测试陌生人查询接口的可用性来检测。具体区别如下：
 */
@Data
public class PluginStatus {
    /**
     * HTTP API 插件已初始化
     */
    @JsonProperty("app_initialized")
    private boolean appInitialized;
    /**
     * HTTP API 插件已启用
     */
    @JsonProperty("app_enabled")
    private boolean appEnabled;
    /**
     * HTTP API 的各内部插件是否正常运行
     */
    @JsonProperty("plugins_good")
    private Object pluginsGood;
    /**
     * HTTP API 插件正常运行（已初始化、已启用、各内部插件正常运行）
     */
    @JsonProperty("app_good")
    private boolean appGood;
    /**
     * 当前 QQ 在线，null 表示无法查询到在线状态
     */
    private boolean online;
    /**
     * HTTP API 插件状态符合预期，意味着插件已初始化，内部插件都在正常运行，且 QQ 在线
     */
    private boolean good;
}
