package org.devefx.spring.boot.demo.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Converter;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * RetrofitConfig
 *
 * @author Yoke
 * @since 1.0
 */
@Configuration
public class RetrofitConfig {

    @Bean
    public Converter.Factory jacksonConverterFactory() {
        return JacksonConverterFactory.create();
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(2000, TimeUnit.MILLISECONDS)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .build();
    }
}
