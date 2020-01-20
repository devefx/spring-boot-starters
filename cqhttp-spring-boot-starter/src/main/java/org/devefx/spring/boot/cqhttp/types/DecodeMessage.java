package org.devefx.spring.boot.cqhttp.types;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.types.message.Node;

import java.util.List;

@Data
@RequiredArgsConstructor
public class DecodeMessage implements Message {

    private final List<Node<?>> nodes;

}
