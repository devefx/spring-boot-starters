package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FriendGroup {
    /**
     * 好友分组 ID
     */
    @JsonProperty("friend_group_id")
    private Integer friendGroupId;
    /**
     * 好友分组名称
     */
    @JsonProperty("friend_group_name")
    private String friendGroupName;
    /**
     * 分组中的好友
     */
    private List<FriendInfo> friends;
}
