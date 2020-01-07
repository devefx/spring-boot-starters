package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 清理数据目录
 *
 * <p>用于清理积攒了太多旧文件的数据目录，如 image。</p>
 */
@Data
public class CleanDataDir implements PostApi<Void> {
    /**
     * 收到清理的目录名，支持 image、record、show、bface
     */
    @JsonProperty("data_dir")
    private String data_dir;
}
