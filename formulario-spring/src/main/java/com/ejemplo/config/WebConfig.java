package com.ejemplo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // No carga favicon.ico
    public void configurePathMatch(org.springframework.web.util.pattern.PathPatternParser parser) {
        parser.setCaseSensitive(false);
    }
}
