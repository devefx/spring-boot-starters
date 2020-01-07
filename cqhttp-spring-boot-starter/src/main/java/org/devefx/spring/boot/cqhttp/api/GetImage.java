package org.devefx.spring.boot.cqhttp.api;

import lombok.Data;
import org.devefx.spring.boot.cqhttp.api.resp.File;

/**
 * 获取图片
 */
@Data
public class GetImage implements GetApi<File> {
    /**
     * 收到的图片文件名（CQ 码的 file 参数），如 6B4DE3DFD1BD271E3297859D41C530F5.jpg
     */
    private final String file;
}
