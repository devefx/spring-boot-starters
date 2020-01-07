package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 登录号信息
 */
@Data
public class LoginInfo {
    /**
     * QQ 号
     */
    @JsonProperty("user_id")
    private Long userId;
    /**
     * QQ 昵称
     */
    private String nickname;
}
