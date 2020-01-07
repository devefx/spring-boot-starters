package org.devefx.spring.boot.cqhttp.api.beta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.GetApi;
import org.devefx.spring.boot.cqhttp.api.resp.VipInfo;

/**
 * 获取会员信息
 */
@Data
@RequiredArgsConstructor
public class GetVipInfo implements GetApi<VipInfo> {
    /**
     * 要查询的 QQ 号
     */
    @JsonProperty("user_id")
    private final long user_id;

    @Override
    public String url() {
        return "_get_vip_info";
    }
}
