package org.devefx.spring.boot.cqhttp.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.devefx.spring.boot.cqhttp.listener.EventListenerDispatcher;
import org.devefx.spring.boot.cqhttp.web.servlet.CqDispatcherServlet;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class CqConfig implements ApplicationContextAware {
    /**
     * 上报数据签名密钥，如果不为空，则会在 HTTP 上报时对 HTTP 正文进行 HMAC SHA1 哈希，
     * 使用 secret 的值作为密钥，计算出的哈希值放在上报的 X-Signature 请求头
     */
    @Value("${http.secret}")
    private String secret;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public EventListenerDispatcher eventListenerDispatcher() {
        return new EventListenerDispatcher(applicationContext);
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
    public ServletRegistrationBean<CqDispatcherServlet> cq(EventListenerDispatcher dispatcher, ObjectMapper objectMapper) {
        return new ServletRegistrationBean<>(new CqDispatcherServlet(dispatcher, objectMapper, secret), "/*");
    }
}
