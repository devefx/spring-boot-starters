package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.devefx.spring.boot.cqhttp.enums.Sex;

/**
 * 获取陌生人信息
 */
@Data
public class StrangerInfo {
    /**
     * QQ 号
     */
    @JsonProperty("user_id")
    private Long userId;
    /**
     * QQ 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private Sex sex;
    /**
     * 年龄
     */
    private Integer age;
}
