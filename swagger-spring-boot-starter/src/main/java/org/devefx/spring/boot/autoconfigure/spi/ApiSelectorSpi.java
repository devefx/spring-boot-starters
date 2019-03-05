package org.devefx.spring.boot.autoconfigure.spi;

import com.google.common.base.Predicate;
import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.util.StringUtils;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import java.lang.annotation.Annotation;

/**
 * ApiSelectorSpi
 *
 * @author Yoke
 * @since 1.0
 */
@SuppressWarnings("ALL")
@Data
public class ApiSelectorSpi {
    @NestedConfigurationProperty
    private final RequestHandlerSelector apis = new RequestHandlerSelector();
    @NestedConfigurationProperty
    private final PathSelector paths = new PathSelector();

    @Data
    public static class RequestHandlerSelector {
        private boolean none;
        private boolean any = true;
        private Class<? extends Annotation> withClassAnnotation;
        private Class<? extends Annotation> withMethodAnnotation;
        private String basePackage;

        public Predicate<RequestHandler> build() {
            Predicate<RequestHandler> predicate = null;
            if (none) {
                predicate = RequestHandlerSelectors.none();
            }
            if (any) {
                predicate = RequestHandlerSelectors.any();
            }
            if (withClassAnnotation != null) {
                predicate = RequestHandlerSelectors.withClassAnnotation(withClassAnnotation);
            }
            if (withMethodAnnotation != null) {
                predicate = RequestHandlerSelectors.withMethodAnnotation(withMethodAnnotation);
            }
            if (StringUtils.hasLength(basePackage)) {
                predicate = RequestHandlerSelectors.basePackage(basePackage);
            }
            return predicate;
        }
    }

    @Data
    public static class PathSelector {
        private boolean none;
        private boolean any = true;
        private String ant;
        private String regex;

        public Predicate<String> build() {
            Predicate<String> predicate = null;
            if (none) {
                predicate = PathSelectors.none();
            }
            if (any) {
                predicate = PathSelectors.any();
            }
            if (StringUtils.hasLength(ant)) {
                predicate = PathSelectors.ant(ant);
            }
            if (StringUtils.hasLength(regex)) {
                predicate = PathSelectors.regex(regex);
            }
            return predicate;
        }
    }
}
