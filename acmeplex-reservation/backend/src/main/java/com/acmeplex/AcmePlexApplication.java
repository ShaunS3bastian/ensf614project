package com.acmeplex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// Import your AdminService if you decide to initialize default admin users
// import com.acmeplex.service.AdminService;

@SpringBootApplication
public class AcmePlexApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcmePlexApplication.class, args);
    }

    // Optional: Initialize default admin user or preload data
    // Uncomment and implement if needed
    /*
    @Bean
    CommandLineRunner init(AdminService adminService) {
        return args -> {
            adminService.createDefaultAdmin();
        };
    }
    */
}
