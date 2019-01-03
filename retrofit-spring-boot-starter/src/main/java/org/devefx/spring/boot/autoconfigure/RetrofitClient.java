package org.devefx.spring.boot.autoconfigure;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import java.lang.annotation.*;

/**
 * RetrofitClient
 *
 * @author Yoke
 * @since 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RetrofitClient {

    /**
     * An absolute URL or resolvable hostname (the protocol is optional).
     */
    String url() default "";

    /**
     * When calling {@link Retrofit#create} on the resulting {@link Retrofit} instance, eagerly validate
     * the configuration of all methods in the supplied interface.
     */
    boolean validateEagerly() default false;

    /**
     * The executor on which {@link Callback} methods are invoked when returning {@link Call} from
     * your service method.
     */
    Class<?> callbackExecutor() default void.class;

}
