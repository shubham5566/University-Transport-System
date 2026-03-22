package com.transport.university.universitytransportsystem.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // ✅ Only ONE safe mapping (no ** conflict)
        registry.addViewController("/{path:[^\\.]*}")
                .setViewName("forward:/");
    }
}