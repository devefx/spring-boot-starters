package org.devefx.spring.boot.cqhttp.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EncodeMessage implements Message {
    @Getter
    private final String source;
}
