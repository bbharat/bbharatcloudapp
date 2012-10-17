package com.cloudapp.config;

import com.cloudapp.rest.CloudAppController;
import com.cloudapp.service.CloudAppService;
import com.cloudapp.service.impl.CloudAppServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class ApplicationConfig {

    @Bean
    public CloudAppService cloudAppService() {
        return new CloudAppServiceImpl();
    }

    @Bean
    public CloudAppController cloudAppController() {
        return new CloudAppController();
    }
}
