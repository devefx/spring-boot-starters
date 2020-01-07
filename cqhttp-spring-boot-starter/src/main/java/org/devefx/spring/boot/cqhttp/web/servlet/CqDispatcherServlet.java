package org.devefx.spring.boot.cqhttp.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.devefx.spring.boot.cqhttp.event.Event;
import org.devefx.spring.boot.cqhttp.listener.EventListenerDispatcher;
import org.devefx.spring.boot.cqhttp.util.HmacSHA1Signer;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class CqDispatcherServlet extends HttpServlet {
    private static final String SIGNATURE_HEADER = "X-Signature";

    private final EventListenerDispatcher dispatcher;
    private final ObjectMapper objectMapper;
    private final String secret;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final byte[] message = StreamUtils.copyToByteArray(req.getInputStream());
        if (checkSignature(req, message)) {
            final Event<?> event = objectMapper.readValue(message, Event.class);
            if (event != null) {
                final Object reply = dispatcher.doEvent(event);
                if (reply != null) {
                    objectMapper.writeValue(resp.getOutputStream(), reply);
                }
            }
            resp.setStatus(200);
        } else {
            resp.setStatus(404);
        }
    }

    private boolean checkSignature(HttpServletRequest req, byte[] message) {
        if (secret != null) {
            final String signature = req.getHeader(SIGNATURE_HEADER);
            final String mySignature = "sha1=" + HmacSHA1Signer.sign(message, secret);
            return mySignature.equals(signature);
        }
        return true;
    }
}
