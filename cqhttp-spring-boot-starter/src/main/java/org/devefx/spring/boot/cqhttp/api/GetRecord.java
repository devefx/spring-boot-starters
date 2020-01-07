package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 获取语音
 *
 * <p>其实并不是真的获取语音，而是转换语音到指定的格式，然后返回语音文件名（data\record 目录下）。注意，要使用此接口，需要安装 酷Q 的 语音组件。</p>
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetRecord {
    /**
     * 收到的语音文件名（CQ 码的 file 参数），如 0B38145AA44505000B38145AA4450500.silk
     */
    private final String file;
    /**
     * 要转换到的格式，目前支持 mp3、amr、wma、m4a、spx、ogg、wav、flac
     */
    @JsonProperty("out_format")
    private final String outFormat;
    /**
     * 是否返回文件的绝对路径（Windows 环境下建议使用，Docker 中不建议）
     */
    @JsonProperty("full_path")
    private boolean fullPath;
}
