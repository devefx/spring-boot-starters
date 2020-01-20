package org.devefx.spring.boot.cqhttp.event;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpHeaders;

import java.io.IOException;

public class TestApi {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();


        Response response = client.newCall(new Request.Builder()
                .url("https://h5.qzone.qq.com/proxy/domain/u.photo.qzone.qq.com/cgi-bin/upp/qun_list_album_v2?" +
                        "g_tk=591983367&qzonetoken=c129b2c52a06fd0567e9484067904bedd0f1a01844a48c8bc34d51cd34223952829960c96d1cc600836a81039e8af48f8b68&callback=shine1_Callback&t=996527704&qunId=438247141&uin=1035213222&start=0&num=36&getMemberRole=1&format=jsonp&platform=qzone&inCharset=utf-8&outCharset=utf-8&source=qzone&cmd=qunGetAlbumList&qunid=438247141&attach_info=&callbackFun=shine1&_=1578904848130")
                .addHeader(HttpHeaders.COOKIE, "pgv_pvi=5392539648; " +
                        //"pgv_pvid=3339633132; " +
                        //"RK=uOiFr2BIOr; " +
                        //"ptcz=673a32f5f791c7d69a39ccf104f9bcdc5db22179495f78b747fc3bd7ed39f924; " +
                        //"__Q_w_s_hat_seed=1; " +
                        //"eas_sid=d1t5F7D694M1F800N8P6c62098; " +
                        //"pgv_si=s9548230656; " +
                        //"_qpsvr_localtk=0.5197521607037194; " +
                        //"pgv_info=ssid=s2097710345; " +
                        //"zzpaneluin=; " +
                        //"zzpanelkey=; " +
                        //"ptisp=ctc; " +
                        //"o_cookie=3447677537; " +
                        //"pac_uid=1_3447677537; " +
                        //"tvfe_boss_uuid=8b61dd0a61d4a1ac; " +
                        "uin=o1035213222; " +
                        //"p_uin=o1035213222; " +
                        //"__Q_w_s__QZN_TodoMsgCnt=1; " +
                        //"_qz_referrer=i.qq.com; " +
                        "skey=@M8hHpO1vp; " +
                        //"pt4_token=q0ahtBU5oFpn-zX5flAKtjYzlG26dspFvVoySwCsaA4_; " +
                        "p_skey=MKQwjf01Elnggt0dbpMEfm*leCntkpi7pU3koX8xbLc_; " +
                        //"rv2=807E24BFE7E87CE819212B17D1B8E69A3282523C126FFBC07D; " +
                        //"property20=896D260893A40AC075523D8AA38C4E07872A560C3A0AF0924AFB6D68F8872E6E5E37892FF01E3AA4" +
                        ""
                )
                .addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36")

                .build()).execute();


        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }

    }
}
