package org.devefx.spring.boot.cqhttp.jackson.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.devefx.spring.boot.cqhttp.types.DecodeMessage;
import org.devefx.spring.boot.cqhttp.types.EncodeMessage;
import org.devefx.spring.boot.cqhttp.types.Message;
import org.devefx.spring.boot.cqhttp.types.message.Node;

import java.io.IOException;
import java.util.List;

public class MessageJsonDeserializer extends JsonDeserializer<Message> {
    @Override
    public Message deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        final JsonToken token = p.currentToken();
        if (token == JsonToken.START_ARRAY) {
            final JavaType javaType = ctxt.getTypeFactory().constructCollectionType(List.class, Node.class);
            return new DecodeMessage(ctxt.readValue(p, javaType));
        } else if (token == JsonToken.VALUE_STRING) {
            return new EncodeMessage(p.getText());
        } else {
            throw new IllegalArgumentException("unknown token: " + token.name());
        }
    }
}
