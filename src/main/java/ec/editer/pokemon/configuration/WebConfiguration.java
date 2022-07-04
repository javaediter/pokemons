/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.editer.pokemon.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Usuario
 */
@Slf4j
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer{
    
    @Value("${origin.client.url}")
    private String origins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info(origins);
        registry.addMapping("/**").allowedOrigins(origins).allowedMethods("GET", "POST", "PUT", "DELETE");
    }
    
}
