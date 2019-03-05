package org.devefx.spring.boot.autoconfigure.spi;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

/**
 * ApiInfoSpi
 *
 * @author Yoke
 * @since 1.0
 */
@Data
public class ApiInfoSpi {
    private String title = "Api Documentation";
    private String description = "Api Documentation";
    private String version = "1.0";
    private String termsOfServiceUrl = "urn:tos";
    private String license = "Apache 2.0";
    private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";
    @NestedConfigurationProperty
    private ContactSpi contact = new ContactSpi();

    public ApiInfo build() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .termsOfServiceUrl(termsOfServiceUrl)
                .license(license)
                .licenseUrl(licenseUrl)
                .contact(contact.build())
                .build();
    }
}
