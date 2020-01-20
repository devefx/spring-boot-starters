package org.devefx.spring.boot.cqhttp.types.message.rich;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AlbumData {
    private String albumName;
    private Integer count;
    private String desc;
    private String h5Url;
    private String h5UrlMobile;
    private String iconUrl;
    private List<Pic> pics;
    @JsonProperty("qunid")
    private Long qunId;
    private ReportCompass reportCompass;
    private String title;
    private Integer total;

    @Data
    public static class Pic {
        private Integer height;
        private Integer width;
        private Integer isVideo;
        private String url;
    }

    @Data
    public static class ReportCompass {
        @JsonProperty("actiontype")
        private String actionType;
        private Reserves reserves;
        @JsonProperty("subactiontype")
        private String subActionType;
        private String table;
    }

    @Data
    public static class Reserves {
        private String click;
        private String expose;
    }
}
