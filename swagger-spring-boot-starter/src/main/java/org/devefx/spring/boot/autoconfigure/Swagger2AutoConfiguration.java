package org.devefx.spring.boot.autoconfigure;

import com.fasterxml.classmate.ResolvedType;
import com.google.common.collect.Ordering;
import org.devefx.spring.boot.autoconfigure.properties.Swagger2Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.service.*;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Swagger2AutoConfiguration
 *
 * @author Yoke
 * @since 1.0
 */
@Configuration
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true", matchIfMissing = true)
@EnableSwagger2
@EnableConfigurationProperties(Swagger2Properties.class)
public class Swagger2AutoConfiguration {

    private final Swagger2Properties properties;

    private List<SecurityContext> securityContexts = newArrayList();
    private List<Parameter> globalOperationParameters = newArrayList();
    private AlternateTypeRule[] alternateTypeRules = new AlternateTypeRule[0];
    private List<ResolvedType> additionalModels = newArrayList();
    private List<Tag> tags = newArrayList();

    private List<SecurityScheme> securitySchemes = newArrayList();
    private Ordering<ApiListingReference> apiListingReferenceOrdering;
    private Ordering<ApiDescription> apiDescriptionOrdering;
    private Ordering<Operation> operationOrdering;

    private List<VendorExtension> extensions = newArrayList();

    private List<GlobalResponseMessage> globalResponseMessages = newArrayList();

    public Swagger2AutoConfiguration(Swagger2Properties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(Docket.class)
    public Docket docket() {
        final Docket docket = properties.buildDocket()
                .securityContexts(securityContexts)
                .securitySchemes(securitySchemes)
                .globalOperationParameters(globalOperationParameters)
                .extensions(extensions)
                .alternateTypeRules(alternateTypeRules)
                .apiListingReferenceOrdering(apiListingReferenceOrdering)
                .apiDescriptionOrdering(apiDescriptionOrdering)
                .operationOrdering(operationOrdering)
                ;
        tags.forEach(docket::tags);
        additionalModels.forEach(docket::additionalModels);
        globalResponseMessages.forEach(grm -> docket.globalResponseMessage(
                grm.getRequestMethod(), grm.getResponseMessages()));
        return docket;
    }

    @Autowired(required = false)
    public void setSecurityContexts(List<SecurityContext> securityContexts) {
        this.securityContexts = securityContexts;
    }

    @Autowired(required = false)
    public void setGlobalOperationParameters(List<Parameter> globalOperationParameters) {
        this.globalOperationParameters = globalOperationParameters;
    }

    @Autowired(required = false)
    public void setAlternateTypeRules(AlternateTypeRule[] alternateTypeRules) {
        this.alternateTypeRules = alternateTypeRules;
    }

    @Autowired(required = false)
    public void setAdditionalModels(List<ResolvedType> additionalModels) {
        this.additionalModels = additionalModels;
    }

    @Autowired(required = false)
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Autowired(required = false)
    public void setSecuritySchemes(List<SecurityScheme> securitySchemes) {
        this.securitySchemes = securitySchemes;
    }

    @Autowired(required = false)
    public void setExtensions(List<VendorExtension> extensions) {
        this.extensions = extensions;
    }

    @Autowired(required = false)
    public void setApiListingReferenceOrdering(Ordering<ApiListingReference> apiListingReferenceOrdering) {
        this.apiListingReferenceOrdering = apiListingReferenceOrdering;
    }

    @Autowired(required = false)
    public void setApiDescriptionOrdering(Ordering<ApiDescription> apiDescriptionOrdering) {
        this.apiDescriptionOrdering = apiDescriptionOrdering;
    }

    @Autowired(required = false)
    public void setOperationOrdering(Ordering<Operation> operationOrdering) {
        this.operationOrdering = operationOrdering;
    }

    @Autowired(required = false)
    public void setGlobalResponseMessages(List<GlobalResponseMessage> globalResponseMessages) {
        globalResponseMessages.forEach(a -> this.globalResponseMessages.stream().filter(b ->
                b.getRequestMethod() == a.getRequestMethod()).findFirst().orElseGet(() -> {
            final GlobalResponseMessage grm = new GlobalResponseMessage(a.getRequestMethod());
            this.globalResponseMessages.add(grm);
            return grm;
        }).addAll(a.getResponseMessages()));
    }
}
