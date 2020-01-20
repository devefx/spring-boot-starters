package org.devefx.spring.boot.cqhttp.exception;

import lombok.Getter;

@Getter
public class ApiStatusException extends RuntimeException {

    private int code;

    public ApiStatusException(int code, String message) {
        super(message);
        this.code = code;
    }
}
