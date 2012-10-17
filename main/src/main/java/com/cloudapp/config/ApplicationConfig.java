package com.cloudapp.config;

import com.cloudapp.rest.CloudAppController;
import com.cloudapp.service.CloudAppService;
import com.cloudapp.service.impl.CloudAppServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

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

    @Bean
    public UrlBasedViewResolver jspViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        return new TilesConfigurer();
    }
}
