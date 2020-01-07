package org.devefx.spring.boot.cqhttp.event.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 群文件上传
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupUploadNoticeEvent extends NoticeEvent {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private Long groupId;

    /**
     * 文件信息
     */
    private File file;

    @Data
    public static class File {
        /**
         * 文件 ID
         */
        private String id;
        /**
         * 文件名
         */
        private String name;
        /**
         * 文件大小（字节数）
         */
        private Long size;
        /**
         * busid（目前不清楚有什么作用）
         */
        private Long busid;
    }
}
