package com.acmeplex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.acmeplex.repository") // Specify your repository package
public class AcmePlexApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcmePlexApplication.class, args);
    }
}
