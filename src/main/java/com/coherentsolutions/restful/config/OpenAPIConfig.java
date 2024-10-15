// File: OpenAPIConfig.java
package com.coherentsolutions.restful.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API Testing Course")
                        .version("1.0")
                        .description("API documentation for the RESTful API testing course")
                );
    }
}
