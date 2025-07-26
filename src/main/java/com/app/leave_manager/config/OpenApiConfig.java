package com.app.leave_manager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI leaveManagerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("LeaveManager API")
                    .version("v1.0")
                    .description("API documentation for the LeaveManager application")
                    .contact(new Contact()
                        .name("Your Name or Team")
                        .email("your@email.com")
                        .url("https://your-company.com"))
                    .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org")));
    }
}
