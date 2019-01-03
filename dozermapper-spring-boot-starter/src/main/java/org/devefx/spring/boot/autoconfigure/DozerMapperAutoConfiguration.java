package org.devefx.spring.boot.autoconfigure;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DozerMapperAutoConfiguration
 *
 * @author Yoke
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(DozerMapperProperties.class)
public class DozerMapperAutoConfiguration {

    private final DozerMapperProperties properties;

    public DozerMapperAutoConfiguration(DozerMapperProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Mapper mapper() {
        return DozerBeanMapperBuilder.create()
                .withMappingFiles(properties.resolveMapperLocations())
                .build();
    }
}
