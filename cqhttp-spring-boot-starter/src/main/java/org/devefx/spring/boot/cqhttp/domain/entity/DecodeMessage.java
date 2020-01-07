package org.devefx.spring.boot.cqhttp.domain.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.domain.entity.message.Node;

import java.util.List;

@Data
@RequiredArgsConstructor
public class DecodeMessage implements Message {

    private final List<Node<?>> nodes;

}
