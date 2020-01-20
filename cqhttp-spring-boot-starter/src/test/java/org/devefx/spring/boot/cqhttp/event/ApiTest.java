package org.devefx.spring.boot.cqhttp.event;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.devefx.spring.boot.cqhttp.api.SendPrivateMsg;
import org.devefx.spring.boot.cqhttp.types.DecodeMessage;
import org.devefx.spring.boot.cqhttp.types.message.AtNode;
import org.devefx.spring.boot.cqhttp.types.message.Node;
import org.devefx.spring.boot.cqhttp.types.message.TextNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ApiTest {

    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
    }

    @Test
    public void sendPrivateMsg() throws JsonProcessingException {
        final List<Node<?>> nodes = new ArrayList<>();
        nodes.add(TextNode.build("123"));
        nodes.add(AtNode.build(3447677537L));

        SendPrivateMsg sendPrivateMsg = new SendPrivateMsg(1035213222L, new DecodeMessage(nodes));
        String text = objectMapper.writeValueAsString(sendPrivateMsg);
        Assert.assertEquals("{\"message\":[{\"type\":\"text\",\"data\":{\"text\":\"123\"}},{\"type\":\"at\",\"data\":{\"qq\":3447677537}}],\"autoEscape\":false,\"user_id\":1035213222}", text);
        System.out.println(text);
    }
}
