package org.devefx.spring.boot.cqhttp.api.beta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.devefx.spring.boot.cqhttp.api.PostApi;

/**
 * 发布群公告
 */
@Data
public class SendGroupNotice implements PostApi<Void> {
    /**
     * 群号
     */
    @JsonProperty("group_id")
    private final Long groupId;
    /**
     * 标题
     */
    @JsonProperty("title")
    private final String title;
    /**
     * 内容
     */
    @JsonProperty("content")
    private final String content;

    @Override
    public String url() {
        return "_get_group_notice";
    }
}
