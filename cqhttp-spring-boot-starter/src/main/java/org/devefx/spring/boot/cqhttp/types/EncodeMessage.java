package org.devefx.spring.boot.cqhttp.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EncodeMessage implements Message {
    @Getter
    private final String source;
}
