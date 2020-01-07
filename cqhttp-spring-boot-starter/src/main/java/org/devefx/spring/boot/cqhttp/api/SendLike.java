package org.devefx.spring.boot.cqhttp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 发送好友赞
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SendLike implements PostApi<Void> {
    /**
     * 对方 QQ 号
     */
    @JsonProperty("user_id")
    @NotNull
    private final Long userId;
    /**
     * 赞的次数，每个好友每天最多 10 次
     */
    @Range(min = 1, max = 10)
    private Integer times = 1;
}
