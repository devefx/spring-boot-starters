package org.devefx.spring.boot.cqhttp.api.resp;

import lombok.Data;

@Data
public class File {
    /**
     * 下载后的图片文件路径，如 C:\Apps\CoolQ\data\image\6B4DE3DFD1BD271E3297859D41C530F5.jpg
     */
    private String file;
}
