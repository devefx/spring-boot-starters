package org.devefx.spring.boot.cqhttp.event;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import org.devefx.spring.boot.cqhttp.api.Api;
import org.devefx.spring.boot.cqhttp.api.GetGroupList;
import org.devefx.spring.boot.cqhttp.event.message.GroupMessageEvent;
import org.devefx.spring.boot.cqhttp.event.message.PrivateMessageEvent;
import org.devefx.spring.boot.cqhttp.event.notice.GroupIncreaseNoticeEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EventTest {

    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
    }

    @Test
    public void privateMessageTest() throws JsonProcessingException {
        String str = "{\"font\":1326744,\"message\":[{\"data\":{\"text\":\"群主定的规矩 俺也不知道\"},\"type\":\"text\"}],\"message_id\":26,\"message_type\":\"private\",\"post_type\":\"message\",\"raw_message\":\"群主定的规矩 俺也不知道\",\"self_id\":3447677537,\"sender\":{\"age\":1,\"nickname\":\"Narcolepsy\",\"sex\":\"male\",\"user_id\":772920046},\"sub_type\":\"other\",\"time\":1577894793,\"user_id\":772920046}";

        Event event = objectMapper.readValue(str, Event.class);

        Assert.assertNotNull(event);
        Assert.assertTrue(event instanceof PrivateMessageEvent);
    }

    @Test
    public void groupMessageEvent() throws JsonProcessingException {
        String str = "{\"anonymous\":null,\"font\":1389456,\"group_id\":564621088,\"message\":[{\"data\":{\"text\":\"1\"},\"type\":\"text\"}],\"message_id\":20,\"message_type\":\"group\",\"post_type\":\"message\",\"raw_message\":\"1\",\"self_id\":3447677537,\"sender\":{\"age\":31,\"area\":\"上海\",\"card\":\"\",\"level\":\"潜水\",\"nickname\":\"逝去\",\"role\":\"owner\",\"sex\":\"unknown\",\"title\":\"\",\"user_id\":1035213222},\"sub_type\":\"normal\",\"time\":1577893774,\"user_id\":1035213222}";

        Event event = objectMapper.readValue(str, Event.class);

        Assert.assertNotNull(event);
        Assert.assertTrue(event instanceof GroupMessageEvent);
    }

    @Test
    public void groupMessageEvent2() throws JsonProcessingException {
        String str = "{\"anonymous\":null,\"font\":1337416,\"group_id\":564621088,\"message\":[{\"data\":{\"qq\":\"3447677537\"},\"type\":\"at\"},{\"data\":{\"text\":\" 照片\"},\"type\":\"text\"},{\"data\":{\"qq\":\"1035213222\"},\"type\":\"at\"}],\"message_id\":66,\"message_type\":\"group\",\"post_type\":\"message\",\"raw_message\":\"[CQ:at,qq=3447677537] 照片[CQ:at,qq=1035213222]\",\"self_id\":3447677537,\"sender\":{\"age\":31,\"area\":\"上海\",\"card\":\"\",\"level\":\"冒泡\",\"nickname\":\"逝去\",\"role\":\"owner\",\"sex\":\"unknown\",\"title\":\"\",\"user_id\":1035213222},\"sub_type\":\"normal\",\"time\":1578222238,\"user_id\":1035213222}";

        Event event = objectMapper.readValue(str, Event.class);

        Assert.assertNotNull(event);
        Assert.assertTrue(event instanceof GroupMessageEvent);
    }

    @Test
    public void groupMessageEvent3() throws JsonProcessingException {
        String str = "{\"anonymous\":null,\"font\":1337416,\"group_id\":564621088,\"message\":\"[CQ:at,qq=3447677537] 照片[CQ:at,qq=1035213222]\",\"message_id\":66,\"message_type\":\"group\",\"post_type\":\"message\",\"raw_message\":\"[CQ:at,qq=3447677537] 照片[CQ:at,qq=1035213222]\",\"self_id\":3447677537,\"sender\":{\"age\":31,\"area\":\"上海\",\"card\":\"\",\"level\":\"冒泡\",\"nickname\":\"逝去\",\"role\":\"owner\",\"sex\":\"unknown\",\"title\":\"\",\"user_id\":1035213222},\"sub_type\":\"normal\",\"time\":1578222238,\"user_id\":1035213222}";

        Event event = objectMapper.readValue(str, Event.class);

        Assert.assertNotNull(event);
        Assert.assertTrue(event instanceof GroupMessageEvent);
    }


    @Test
    public void groupIncreaseNoticeEvent() throws JsonProcessingException {
        String str = "{\"group_id\":564621088,\"notice_type\":\"group_increase\",\"operator_id\":0,\"post_type\":\"notice\",\"self_id\":3447677537,\"sub_type\":\"invite\",\"time\":1577893771,\"user_id\":3447677537}";

        Event event = objectMapper.readValue(str, Event.class);

        Assert.assertNotNull(event);
        Assert.assertTrue(event instanceof GroupIncreaseNoticeEvent);

        final HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.scheme("http")
                .host("localhost")
                .port(8080)
                .query("name=1&age=18").addQueryParameter("l", "安慰");
        System.out.println(builder.build());

    }

}
