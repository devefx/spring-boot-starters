package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 设置群组专属头衔
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupSpecialTitle implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private final Long groupId;
    /**
     * 要设置的 QQ 号
     */
    @JsonProperty("user_id")
    private final Long userId;
    /**
     * 专属头衔，不填或空字符串表示删除专属头衔
     */
    @JsonProperty("special_title")
    private String specialTitle;
    /**
     * 专属头衔有效期，单位秒，-1 表示永久，不过此项似乎没有效果，可能是只有某些特殊的时间长度有效，有待测试
     */
    private Integer duration = -1;
}
