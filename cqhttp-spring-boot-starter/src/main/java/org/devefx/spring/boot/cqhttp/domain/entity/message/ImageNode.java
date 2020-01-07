package org.devefx.spring.boot.cqhttp.domain.entity.message;

import lombok.Data;
import lombok.ToString;

import java.net.URL;

public class ImageNode extends Node<ImageNode.Image> {
    public static final String TYPE_NAME = "image";

    public ImageNode() {
        super(TYPE_NAME);
    }

    @Data
    @ToString
    public static class Image {
        private String file;
        private URL url;
    }
}
