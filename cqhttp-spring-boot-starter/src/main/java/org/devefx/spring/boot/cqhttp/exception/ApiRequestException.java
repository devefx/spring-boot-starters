package org.devefx.spring.boot.cqhttp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.devefx.spring.boot.cqhttp.api.resp.ApiResp.Status;

@Getter
@AllArgsConstructor
public class ApiRequestException extends RuntimeException {

    private Status status;

    private int code;

}
