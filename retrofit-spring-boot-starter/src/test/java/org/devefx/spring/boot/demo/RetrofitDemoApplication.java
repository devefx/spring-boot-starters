package org.devefx.spring.boot.demo;

import org.devefx.spring.boot.autoconfigure.EnableRetrofitClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DemoApplication
 *
 * @author Yoke
 * @since 1.0
 */
@EnableRetrofitClients
@SpringBootApplication
public class RetrofitDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetrofitDemoApplication.class, args);
    }
}
