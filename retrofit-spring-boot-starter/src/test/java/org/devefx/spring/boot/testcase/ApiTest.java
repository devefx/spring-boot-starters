package org.devefx.spring.boot.testcase;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.devefx.spring.boot.demo.RetrofitDemoApplication;
import org.devefx.spring.boot.demo.api.GitHubApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * ApiTest
 *
 * @author Yoke
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RetrofitDemoApplication.class)
public class ApiTest {

    private static Log log = LogFactory.getLog(ApiTest.class);

    @Autowired
    private GitHubApi gitHubApi;

    @Test
    public void testRepo() throws IOException {
        Call<JsonNode> call = gitHubApi.repo("devefx", "spring-boot-starters");

        Response<JsonNode> response = call.execute();

        log.info(response.code());

        if (response.isSuccessful()) {
            log.info(response.body());
        } else if (response.errorBody() != null) {
            log.warn(response.errorBody().string());
        }
    }

    @Test
    public void testSearchRepositories() throws IOException {
        Call<JsonNode> call = gitHubApi.searchRepositories("devefx/spring-boot-starters", null, null);

        Response<JsonNode> response = call.execute();

        log.info(response.code());

        if (response.isSuccessful()) {
            log.info(response.body());
        } else if (response.errorBody() != null) {
            log.warn(response.errorBody().string());
        }
    }
}
