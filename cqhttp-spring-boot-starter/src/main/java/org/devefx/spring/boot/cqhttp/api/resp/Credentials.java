package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 凭证
 */
@Data
public class Credentials {
    /**
     * Cookies
     */
    private String cookies;
    /**
     * CSRF Token
     */
    @JsonProperty("csrf_token")
    private String csrfToken;
}
