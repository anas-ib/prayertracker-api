package com.anas.prayertracker_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("QadhaTracker API")
                                .description("Secure REST API for tracking pending prayers with Firebase Authentication.")
                                .version("v1.0")
                )
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .schemaRequirement(
                        "Bearer Authentication",
                        new SecurityScheme()
                                .name("Authorization")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                );
    }
}