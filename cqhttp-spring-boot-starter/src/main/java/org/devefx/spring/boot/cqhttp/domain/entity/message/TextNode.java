package org.devefx.spring.boot.cqhttp.domain.entity.message;

import lombok.*;

public class TextNode extends Node<TextNode.Text> {
    public static final String TYPE_NAME = "text";

    public TextNode() {
        super(TYPE_NAME);
    }

    public static TextNode build(String text) {
        final TextNode node = new TextNode();
        node.setData(new Text(text));
        return node;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Text {
        private String text;
    }
}
