package org.devefx.spring.boot.cqhttp.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.resp.Credentials;

/**
 * 获取 QQ 相关接口凭证
 *
 * <p>{@link GetCookies} 和 {@link GetCsrfToken} 两个接口的合并。</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCredentials implements GetApi<Credentials> {
    /**
     * 需要获取 cookies 的域名
     */
    private String domain;
}
