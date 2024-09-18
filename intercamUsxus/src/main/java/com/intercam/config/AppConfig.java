package com.intercam.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author Luis.Bonifaz
 */

/*
*Configuraciones recibidas desde el properties
*/
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    
    String title = "api.intercam.usxus";
    String version;
    
}