package org.devefx.spring.boot.cqhttp.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.enums.PostType;
import org.devefx.spring.boot.cqhttp.event.message.MessageEvent;
import org.devefx.spring.boot.cqhttp.event.notice.NoticeEvent;
import org.devefx.spring.boot.cqhttp.event.request.RequestEvent;

@Data
@ToString
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "post_type", visible = true)
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "message", value = MessageEvent.class),
        @JsonSubTypes.Type(name = "notice", value = NoticeEvent.class),
        @JsonSubTypes.Type(name = "request", value = RequestEvent.class)
})
public abstract class Event<T> {
    /**
     * 上报类型
     */
    @JsonProperty("post_type")
    private PostType postType;

    /**
     * 收到消息的机器人 QQ 号
     */
    @JsonProperty("self_id")
    private Long selfId;

    /**
     * 事件发生的时间戳
     */
    private Long time;
}
