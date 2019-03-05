package org.devefx.spring.boot.demo.config;

import org.devefx.spring.boot.autoconfigure.GlobalResponseMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiKey;

/**
 * SwaggerConfig
 *
 * @author Yoke
 * @since 1.0
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public ApiKey userId() {
        return new ApiKey("uid", "X-USER-ID", "header");
    }

    @Bean
    public ApiKey userEmail() {
        return new ApiKey("email", "X-USER-EMAIL", "header");
    }

    @Bean
    public GlobalResponseMessage globalResponseMessage() {
        return new GlobalResponseMessage(RequestMethod.GET)
                .add(new ResponseMessageBuilder()
                        .code(500).message("500 ERROR")
                        .build())
                .add(new ResponseMessageBuilder()
                        .code(404).message("404 Not Found")
                        .build());
    }
}
