package org.devefx.spring.boot.cqhttp.domain.entity.message;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "text", value = TextNode.class),
        @JsonSubTypes.Type(name = "image", value = ImageNode.class),
        @JsonSubTypes.Type(name = "face", value = FaceNode.class),
        @JsonSubTypes.Type(name = "at", value = AtNode.class),
        @JsonSubTypes.Type(name = "rich", value = RichNode.class)
})
public abstract class Node<T> {
    private final String type;
    private T data;
}
