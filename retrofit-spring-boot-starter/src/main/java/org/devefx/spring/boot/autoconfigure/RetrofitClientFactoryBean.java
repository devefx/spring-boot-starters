package org.devefx.spring.boot.autoconfigure;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.util.Collection;
import java.util.concurrent.Executor;

/**
 * RetrofitClientFactoryBean
 *
 * @author Yoke
 * @since 1.0
 */
public class RetrofitClientFactoryBean implements FactoryBean<Object>, InitializingBean, ApplicationContextAware {

    private Class<?> type;

    private String url;

    private boolean validateEagerly;

    private Class<? extends Executor> callbackExecutor = null;

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(this.url, "Url must be set");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setValidateEagerly(boolean validateEagerly) {
        this.validateEagerly = validateEagerly;
    }

    public void setCallbackExecutor(Class<? extends Executor> callbackExecutor) {
        this.callbackExecutor = callbackExecutor;
    }

    protected <T> T getOptional(Class<T> type) {
        try {
            return this.applicationContext.getBean(type);
        } catch (NoSuchBeanDefinitionException e) {
            return null;
        }
    }

    protected <T> Collection<T> getAll(Class<T> type) {
        return this.applicationContext.getBeansOfType(type).values();
    }

    protected Retrofit retrofit() {
        Retrofit.Builder builder = new Retrofit.Builder().validateEagerly(this.validateEagerly).baseUrl(this.url);

        OkHttpClient client = getOptional(OkHttpClient.class);
        if (client != null) {
            builder.client(client);
        }
        Call.Factory callFactory = getOptional(Call.Factory.class);
        if (callFactory != null) {
            builder.callFactory(callFactory);
        }
        Collection<Converter.Factory> converterFactories = getAll(Converter.Factory.class);
        if (converterFactories != null) {
            for (Converter.Factory factory : converterFactories) {
                builder.addConverterFactory(factory);
            }
        }
        Collection<CallAdapter.Factory> callAdapterFactories = getAll(CallAdapter.Factory.class);
        if (callAdapterFactories != null) {
            for (CallAdapter.Factory factory : callAdapterFactories) {
                builder.addCallAdapterFactory(factory);
            }
        }
        if (callbackExecutor != null) {
            final Executor executor = getOptional(callbackExecutor);
            if (callbackExecutor != null) {
                builder.callbackExecutor(executor);
            }
        }
        return builder.build();
    }

    @Override
    public Object getObject() throws Exception {
        final Retrofit retrofit = retrofit();
        return retrofit.create(this.type);
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
