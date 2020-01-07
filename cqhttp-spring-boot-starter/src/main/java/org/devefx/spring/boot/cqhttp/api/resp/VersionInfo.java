package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VersionInfo {
    /**
     * 酷Q 根目录路径
     */
    @JsonProperty("coolq_directory")
    private String coolqDirectory;
    /**
     * 酷Q 版本，air 或 pro
     */
    @JsonProperty("coolq_edition")
    private String coolqEdition;
    /**
     * HTTP API 插件版本，例如 2.1.3
     */
    @JsonProperty("plugin_version")
    private String pluginVersion;
    /**
     * HTTP API 插件 build 号
     */
    @JsonProperty("plugin_build_number")
    private Long pluginBuildNumber;
    /**
     * HTTP API 插件编译配置，debug 或 release
     */
    @JsonProperty("plugin_build_configuration")
    private String pluginBuildConfiguration;
}
