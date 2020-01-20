package org.devefx.spring.boot.cqhttp.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.CqHttpApi;
import org.devefx.spring.boot.cqhttp.listener.EventListenerDispatcher;
import org.devefx.spring.boot.cqhttp.web.servlet.CqDispatcherServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties(CqHttpProperties.class)
public class CqHttpAutoConfiguration {

    private final CqHttpProperties properties;

    @Bean
    public EventListenerDispatcher eventListenerDispatcher(ApplicationContext applicationContext) {
        return new EventListenerDispatcher(applicationContext, properties.isPublishEventToSpring());
    }

    @Bean
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
        return objectMapper;
    }

    @Bean
    public ServletRegistrationBean<CqDispatcherServlet> cqDispatcherServlet(
            EventListenerDispatcher dispatcher, ObjectMapper objectMapper) {
        return new ServletRegistrationBean<>(new CqDispatcherServlet(dispatcher,
                objectMapper, properties.getSecret()), "/*");
    }

    @Bean
    public CqHttpApi cqHttpApi() {
        return new CqHttpApi.Builder()
                .host(properties.getHost())
                .port(properties.getPort())
                .accessToken(properties.getAccessToken())
                .build();
    }
}
