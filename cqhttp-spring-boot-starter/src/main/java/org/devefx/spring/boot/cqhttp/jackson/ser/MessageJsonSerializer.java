package org.devefx.spring.boot.cqhttp.jackson.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.devefx.spring.boot.cqhttp.types.DecodeMessage;
import org.devefx.spring.boot.cqhttp.types.EncodeMessage;
import org.devefx.spring.boot.cqhttp.types.Message;

import java.io.IOException;
import java.util.List;

public class MessageJsonSerializer extends JsonSerializer<Message> {
    @Override
    public void serialize(Message value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value instanceof DecodeMessage) {
            JsonSerializer<Object> serializer = serializers.findValueSerializer(List.class);
            serializer.serialize(((DecodeMessage) value).getNodes(), gen, serializers);
        } else if (value instanceof EncodeMessage) {
            gen.writeString(((EncodeMessage) value).getSource());
        }
    }
}
