package org.devefx.spring.boot.cqhttp.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.devefx.spring.boot.cqhttp.enums.Sex;

@Data
public class Sender {
    /**
     * 发送者 QQ 号
     */
    @JsonProperty("user_id")
    private Long userId;

    /**
     * 昵称
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
