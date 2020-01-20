package org.devefx.spring.boot.cqhttp.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.devefx.spring.boot.cqhttp.jackson.deser.MessageJsonDeserializer;
import org.devefx.spring.boot.cqhttp.jackson.ser.MessageJsonSerializer;

@JsonDeserialize(using = MessageJsonDeserializer.class)
@JsonSerialize(using = MessageJsonSerializer.class)
public interface Message {

}
