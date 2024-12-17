package com.aluracursos.screenmatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
	// @formatter:off
	// Compare this snippet from src/main/java/com/aluracursos/screenmatch/config/CorsConfiguration.java:
	// package com.aluracursos.screenmatch.config;
	//
	// import org.springframework.context.annotation.Configuration;
	// import org.springframework.web.servlet.config.annotation.CorsRegistry;
	// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
	//
	// @Configuration
	// public class CorsConfiguration implements WebMvcConfigurer {
	// 	@Override
	//     public void addCorsMappings(CorsRegistry registry) {
	//         registry.addMapping("/**")
	//                 .allowedOrigins("http://
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
