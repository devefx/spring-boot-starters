package org.devefx.spring.boot.cqhttp.api.beta;

import lombok.Getter;
import org.devefx.spring.boot.cqhttp.api.GetApi;
import org.devefx.spring.boot.cqhttp.api.resp.FriendListFlat;

/**
 * 获取好友列表
 */
@Getter
public class GetFriendListFlat implements GetApi<FriendListFlat> {
    /**
     * 是否获取扁平化的好友数据，即所有好友放在一起、所有分组放在一起，而不是按分组层级
     */
    private final boolean flat = true;

    @Override
    public String url() {
        return "_get_friend_list";
    }
}
