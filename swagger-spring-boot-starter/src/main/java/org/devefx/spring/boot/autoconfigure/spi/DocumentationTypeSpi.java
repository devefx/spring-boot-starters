package org.devefx.spring.boot.autoconfigure.spi;

import springfox.documentation.spi.DocumentationType;

/**
 * DocumentationTypeSpi
 *
 * @author Yoke
 * @since 1.0
 */
public enum DocumentationTypeSpi {
    SWAGGER_12(DocumentationType.SWAGGER_12),
    SWAGGER_2(DocumentationType.SWAGGER_2),
    SPRING_WEB(DocumentationType.SPRING_WEB)
    ;
    private DocumentationType value;

    DocumentationTypeSpi(DocumentationType value) {
        this.value = value;
    }

    public DocumentationType getValue() {
        return value;
    }
}
