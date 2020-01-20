package org.devefx.spring.boot.cqhttp;

import okhttp3.OkHttpClient;
import org.devefx.spring.boot.cqhttp.api.GetCookies;
import org.devefx.spring.boot.cqhttp.api.GetCredentials;
import org.devefx.spring.boot.cqhttp.api.beta.GetFriendListFlat;
import org.devefx.spring.boot.cqhttp.api.resp.Cookies;
import org.devefx.spring.boot.cqhttp.api.resp.Credentials;
import org.devefx.spring.boot.cqhttp.api.resp.FriendListFlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class);
    }

    @Autowired
    public void test(CqHttpApi cqHttpApi) {

        Credentials info = cqHttpApi.execute(new GetCredentials());


        System.out.println(info);




    }
}
