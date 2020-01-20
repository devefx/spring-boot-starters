package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.devefx.spring.boot.cqhttp.enums.Role;
import org.devefx.spring.boot.cqhttp.enums.Sex;

@Data
public class GroupMemberInfo {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private final Long groupId;
    /**
     * QQ 号
     */
    @JsonProperty("user_id")
    private final Long userId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 群名片／备注
     */
    private String card;
    /**
     * 性别
     */
    private Sex sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 地区
     */
    private String area;
    /**
     * 加群时间戳
     */
    @JsonProperty("join_time")
    private Long joinTime;
    /**
     * 最后发言时间戳
     */
    @JsonProperty("last_sent_time")
    private Long lastSentTime;
    /**
     * 成员等级
     */
    private String level;
    /**
     * 角色
     */
    private Role role;
    /**
     * 是否不良记录成员
     */
    private Boolean unfriendly;
    /**
     * 专属头衔
     */
    private String title;
    /**
     * 专属头衔过期时间戳
     */
    @JsonProperty("title_expire_time")
    private Long titleExpireTime;
    /**
     * 是否允许修改群名片
     */
    @JsonProperty("card_changeable")
    private Boolean cardChangeable;
}
