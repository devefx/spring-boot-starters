package org.devefx.spring.boot.cqhttp.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devefx.spring.boot.cqhttp.api.resp.Cookies;

/**
 * 获取 Cookies
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCookies implements GetApi<Cookies> {
    /**
     * 需要获取 cookies 的域名
     */
    private String domain;
}
