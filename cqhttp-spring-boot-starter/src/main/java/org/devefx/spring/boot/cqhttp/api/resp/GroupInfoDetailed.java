package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.devefx.spring.boot.cqhttp.domain.enums.Role;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class GroupInfoDetailed extends GroupInfo {
    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    private Long createTime;
    /**
     * 群分类
     */
    private Integer category;
    /**
     * 群介绍
     */
    private String introduction;
    /**
     * 群主和管理员列表
     */
    private List<AdminInfo> admins;
    /**
     * 群主和管理员数
     */
    @JsonProperty("admin_count")
    private Integer adminCount;
    /**
     * 最大群主和管理员数
     */
    @JsonProperty("max_admin_count")
    private Integer maxAdminCount;
    /**
     * 群主 QQ 号
     */
    @JsonProperty("owner_id")
    private Long ownerId;

    @Data
    public static class AdminInfo {
        /**
         * QQ 号
         */
        @JsonProperty("user_id")
        private Long userId;
        /**
         * 昵称
         */
        private String nickname;
        /**
         * 角色
         */
        private Role role;
    }
}
