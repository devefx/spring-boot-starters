package org.devefx.spring.boot.cqhttp.event.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.types.Sender;
import org.devefx.spring.boot.cqhttp.event.message.reply.DiscussMessageReply;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DiscussMessageEvent extends MessageEvent<DiscussMessageReply> {
    /**
     * 讨论组 ID
     */
    @JsonProperty("discuss_id")
    private Long discussId;

    /**
     * 发送人信息
     */
    private Sender sender;
}
