package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 好友信息
 */
@Data
public class FriendInfo {
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
     * 备注名
     */
    private String remark;
}
