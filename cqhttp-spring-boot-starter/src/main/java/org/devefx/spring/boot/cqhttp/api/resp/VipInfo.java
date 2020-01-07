package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VipInfo {
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
     * QQ 等级
     */
    private Integer level;
    /**
     * 等级加速度
     */
    @JsonProperty("level_speed")
    private Integer levelSpeed;
    /**
     * 会员等级
     */
    @JsonProperty("vip_level")
    private Integer vipLevel;
    /**
     * 会员成长速度
     */
    @JsonProperty("vip_growth_speed")
    private Integer vipGrowthSpeed;
    /**
     * 会员成长总值
     */
    @JsonProperty("vip_growth_total")
    private String vipGrowthTotal;
}
