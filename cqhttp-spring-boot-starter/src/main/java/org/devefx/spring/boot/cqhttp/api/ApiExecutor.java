package org.devefx.spring.boot.cqhttp.api;

public interface ApiExecutor {

    <T extends Api<R>, R> R execute(T method);

}
