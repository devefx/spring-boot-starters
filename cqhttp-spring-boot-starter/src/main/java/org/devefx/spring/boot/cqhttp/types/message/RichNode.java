package org.devefx.spring.boot.cqhttp.types.message;

import lombok.Data;
import lombok.ToString;

public class RichNode extends Node<RichNode.Rich> {
    public static final String TYPE_NAME = "rich";

    public RichNode() {
        super(TYPE_NAME);
    }

    @Data
    @ToString
    public static class Rich {
        private String title;
        private Rich content;
    }
}
