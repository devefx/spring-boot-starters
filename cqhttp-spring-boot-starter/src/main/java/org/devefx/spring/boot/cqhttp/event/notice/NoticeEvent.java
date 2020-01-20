package org.devefx.spring.boot.cqhttp.event.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devefx.spring.boot.cqhttp.enums.NoticeType;
import org.devefx.spring.boot.cqhttp.event.Event;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "notice_type", visible = true)
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "group_upload", value = GroupUploadNoticeEvent.class),
        @JsonSubTypes.Type(name = "group_admin", value = GroupAdminNoticeEvent.class),
        @JsonSubTypes.Type(name = "group_decrease", value = GroupDecreaseNoticeEvent.class),
        @JsonSubTypes.Type(name = "group_increase", value = GroupIncreaseNoticeEvent.class),
        @JsonSubTypes.Type(name = "group_ban", value = GroupBanNoticeEvent.class),
        @JsonSubTypes.Type(name = "friend_add", value = FriendAddNoticeEvent.class)
})
public abstract class NoticeEvent extends Event<Void> {
    /**
     * 通知类型
     */
    @JsonProperty("notice_type")
    private NoticeType noticeType;

    /**
     * 发送者 QQ 号
     */
    @JsonProperty("user_id")
    private Long userId;
}
