package org.devefx.spring.boot.autoconfigure.properties;

import lombok.Data;
import org.devefx.spring.boot.autoconfigure.spi.ApiInfoSpi;
import org.devefx.spring.boot.autoconfigure.spi.ApiSelectorSpi;
import org.devefx.spring.boot.autoconfigure.spi.DocumentationTypeSpi;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

/**
 * Swagger2Properties
 *
 * @author Yoke
 * @since 1.0
 */
@Data
@ConfigurationProperties("swagger")
public class Swagger2Properties {

    private boolean enabled = true;

    private DocumentationTypeSpi documentationType = DocumentationTypeSpi.SWAGGER_2;
    private Class[] genericModelSubstitutes = new Class[0];
    private final List<DirectModelSubstitute> directModelSubstitutes = newArrayList();
    private Class[] ignoredParameterTypes = new Class[0];
    private final List<String> protocols = newArrayList();
    private final List<String> produces = newArrayList();
    private final List<String> consumes = newArrayList();

    @NestedConfigurationProperty
    private final ApiInfoSpi apiInfo = new ApiInfoSpi();
    private String groupName = Docket.DEFAULT_GROUP_NAME;
    private boolean externallyConfiguredFlag = true;
    private boolean forCodeGeneration;
    private boolean useDefaultResponseMessages = true;
    private String host = "";
    private String pathMapping;
    private boolean enableUrlTemplating;

    @NestedConfigurationProperty
    private final ApiSelectorSpi select = new ApiSelectorSpi();

    public Docket buildDocket() {
        final Docket docket = new Docket(documentationType.getValue())
                .select()
                    .apis(select.getApis().build())
                    .paths(select.getPaths().build())
                    .build()
                .genericModelSubstitutes(genericModelSubstitutes)
                .ignoredParameterTypes(ignoredParameterTypes)
                .protocols(newHashSet(protocols))
                .produces(newHashSet(produces))
                .consumes(newHashSet(consumes))
                .apiInfo(apiInfo.build())
                .groupName(groupName)
                .enable(externallyConfiguredFlag)
                .forCodeGeneration(forCodeGeneration)
                .useDefaultResponseMessages(useDefaultResponseMessages)
                .host(host)
                .pathMapping(pathMapping)
                .enableUrlTemplating(enableUrlTemplating);
        directModelSubstitutes.forEach(item-> docket.directModelSubstitute(item.clazz, item.with));
        return docket;
    }

    @Data
    public static class DirectModelSubstitute {
        private Class<?> clazz;
        private Class<?> with;
    }
}
