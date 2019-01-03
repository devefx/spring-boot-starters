package org.devefx.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DozerMapperProperties
 *
 * @author Yoke
 * @since 1.0
 */
@ConfigurationProperties(prefix = "dozermapper")
public class DozerMapperProperties {

    private String[] mapperLocations;

    public String[] getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String[] mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public List<String> resolveMapperLocations() {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<String> mappingFiles = new ArrayList<>();
        if (this.mapperLocations != null) {
            for (String mapperLocation : this.mapperLocations) {
                try {
                    Resource[] resources = resourceResolver.getResources(mapperLocation);
                    for (Resource resource : resources) {
                        mappingFiles.add(resource.getURL().toExternalForm());
                    }
                } catch (IOException e) {
                    // ignore
                }
            }
        }
        return mappingFiles;
    }
}
