package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc  // Ensure Spring MVC is properly configured
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Apply CORS only to API requests
                        .allowedOrigins("http://localhost:5173") // Allow frontend requests
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow all necessary HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow credentials if needed
            }
        };
    }
}
