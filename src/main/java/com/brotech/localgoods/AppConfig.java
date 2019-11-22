package com.brotech.localgoods;

import com.brotech.localgoods.facade.impl.DefaultAddressFacade;
import com.brotech.localgoods.facade.impl.DefaultUserFacade;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public DefaultUserFacade userFacade() {
        return new DefaultUserFacade();
    }

    @Bean
    public DefaultAddressFacade addressFacade() {
        return new DefaultAddressFacade();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
