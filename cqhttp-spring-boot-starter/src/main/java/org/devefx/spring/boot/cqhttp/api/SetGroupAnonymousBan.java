package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 群组匿名用户禁言
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetGroupAnonymousBan implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    @NotNull
    private final Long groupId;
    /**
     * 可选，要禁言的匿名用户对象（群消息上报的 anonymous 字段）
     */
    private Object anonymous;
    /**
     * 可选，要禁言的匿名用户的 flag（需从群消息上报的数据中获得）
     */
    @JsonProperty("anonymous_flag")
    private String anonymousFlag;
    /**
     * 禁言时长，单位秒，无法取消匿名用户禁言
     */
    private Integer duration = 30 * 60;
}
