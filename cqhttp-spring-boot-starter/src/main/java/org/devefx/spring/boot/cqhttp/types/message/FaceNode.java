package org.devefx.spring.boot.cqhttp.types.message;

import lombok.Data;
import lombok.ToString;

public class FaceNode extends Node<FaceNode.Face> {
    public static final String TYPE_NAME = "face";

    public FaceNode() {
        super(TYPE_NAME);
    }

    @Data
    @ToString
    public static class Face {
        private Integer id;
    }
}
