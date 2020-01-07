package org.devefx.spring.boot.cqhttp.domain.entity.message;

import lombok.*;

public class AtNode extends Node<AtNode.At> {
    public static final String TYPE_NAME = "at";

    public AtNode() {
        super(TYPE_NAME);
    }

    public static AtNode build(Long qq) {
        final AtNode node = new AtNode();
        node.setData(new At(qq));
        return node;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class At {
        private Long qq;
    }
}
