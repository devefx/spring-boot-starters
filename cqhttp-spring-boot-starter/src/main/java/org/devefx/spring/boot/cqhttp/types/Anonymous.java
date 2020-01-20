package org.devefx.spring.boot.cqhttp.types;

import lombok.Data;

@Data
public class Anonymous {
    /**
     * 匿名用户 ID
     */
    private Long id;

    /**
     * 匿名用户名称
     */
    private String name;

    /**
     * 匿名用户 flag，在调用禁言 API 时需要传入
     */
    private String flag;
}
