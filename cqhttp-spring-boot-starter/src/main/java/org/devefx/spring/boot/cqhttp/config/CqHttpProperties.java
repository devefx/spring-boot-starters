package org.devefx.spring.boot.cqhttp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "cq.http")
public class CqHttpProperties {
    /**
     * HTTP 服务器监听的 IP
     */
    private String host = "localhost";
    /**
     * HTTP 服务器监听的端口
     */
    private int port = 5700;
    /**
     * API 访问 token
     */
    private String accessToken;
    /**
     * 上报数据签名密钥，如果不为空，则会在 HTTP 上报时对 HTTP 正文进行 HMAC SHA1 哈希，
     * 使用 secret 的值作为密钥，计算出的哈希值放在上报的 X-Signature 请求头。
     *
     * <p>例如 X-Signature: sha1=f9ddd4863ace61e64f462d41ca311e3d2c1176e2</p>
     */
    private String secret;
    /**
     * 接收到消息事件时是否同时使用 {@link org.springframework.context.ApplicationEventPublisher#publishEvent} 通知事件
     */
    private boolean publishEventToSpring = true;
}
