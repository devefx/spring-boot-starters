package org.devefx.spring.boot.cqhttp.api.beta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.GetApi;
import org.devefx.spring.boot.cqhttp.api.resp.GroupInfoDetailed;

/**
 * 获取群信息
 */
@Data
@RequiredArgsConstructor
public class GetGroupInfo implements GetApi<GroupInfoDetailed> {
    /**
     * 要查询的群号
     */
    @JsonProperty("group_id")
    private final Long groupId;

    @Override
    public String url() {
        return "_get_group_info";
    }
}
