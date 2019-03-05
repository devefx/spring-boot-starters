package org.devefx.spring.boot.autoconfigure.spi;

import lombok.Data;
import springfox.documentation.service.Contact;

/**
 * ContactSpi
 *
 * @author Yoke
 * @since 1.0
 */
@Data
public class ContactSpi {

    private String name = "";
    private String url = "";
    private String email = "";

    public Contact build() {
        return new Contact(name, url, email);
    }
}
