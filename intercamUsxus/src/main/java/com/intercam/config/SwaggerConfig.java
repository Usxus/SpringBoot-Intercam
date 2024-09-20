package com.intercam.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Luis.Bonifaz
 */
@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("API.INTERCAM.USXUS")
                    .version("1.0.0")
                    .description("Documentación de la API")
                    .contact(new Contact()
                        .name("Desarrollador de software")
                        .email("luisbonfz@gmail.com")
                        .url(""))
                );
    }
    
}
