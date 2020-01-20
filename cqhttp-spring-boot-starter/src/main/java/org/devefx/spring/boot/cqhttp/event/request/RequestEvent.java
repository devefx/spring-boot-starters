package org.devefx.spring.boot.cqhttp.event.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.enums.RequestType;
import org.devefx.spring.boot.cqhttp.event.Event;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "request_type", visible = true)
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "friend", value = FriendRequestEvent.class),
        @JsonSubTypes.Type(name = "group", value = GroupRequestEvent.class)
})
public abstract class RequestEvent<T> extends Event<T> {
    /**
     * 请求类型
     */
    @JsonProperty("request_type")
    private RequestType requestType;

    /**
     * 发送请求的 QQ 号
     */
    @JsonProperty("user_id")
    private Long userId;

    /**
     * 验证信息（可能包含 CQ 码，特殊字符被转义）
     */
    private String comment;

    /**
     * 请求 flag，在调用处理请求的 API 时需要传入
     */
    private String flag;
}
