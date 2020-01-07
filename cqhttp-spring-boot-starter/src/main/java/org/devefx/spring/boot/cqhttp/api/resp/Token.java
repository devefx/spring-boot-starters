package org.devefx.spring.boot.cqhttp.api.resp;

import lombok.Data;

@Data
public class Token {
    /**
     * CSRF Token
     */
    private String token;
}
