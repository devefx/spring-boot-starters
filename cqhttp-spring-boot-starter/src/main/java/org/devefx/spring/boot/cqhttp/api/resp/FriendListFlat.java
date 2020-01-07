package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FriendListFlat {
    /**
     * 好友分组列表
     */
    @JsonProperty("friend_groups")
    private List<FriendGroup> groups;
    /**
     * 好友列表
     */
    @JsonProperty("friends")
    private List<Friend> friends;

    @Data
    public static class FriendGroup {
        /**
         * 好友分组 ID
         */
        @JsonProperty("friend_group_id")
        private Integer groupId;
        /**
         * 好友分组名称
         */
        @JsonProperty("friend_group_name")
        private String groupName;
    }

    @Data
    public static class Friend {
        /**
         * 好友昵称
         */
        private String nickname;
        /**
         * 好友备注
         */
        private String remark;
        /**
         * 好友 QQ 号
         */
        @JsonProperty("user_id")
        private Long userId;
        /**
         * 好友所在分组 ID
         */
        @JsonProperty("friend_group_id")
        private Integer groupId;
    }
}
