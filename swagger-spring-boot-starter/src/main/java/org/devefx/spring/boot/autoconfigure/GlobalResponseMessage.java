package org.devefx.spring.boot.autoconfigure;

import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.service.ResponseMessage;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * GlobalResponseMessage
 *
 * @author Yoke
 * @since 1.0
 */
@Getter
public class GlobalResponseMessage {
    private final RequestMethod requestMethod;
    private final List<ResponseMessage> responseMessages = newArrayList();

    public GlobalResponseMessage(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public GlobalResponseMessage add(ResponseMessage responseMessage) {
        this.responseMessages.add(responseMessage);
        return this;
    }

    public GlobalResponseMessage addAll(List<ResponseMessage> responseMessages) {
        this.responseMessages.addAll(responseMessages);
        return this;
    }
}
