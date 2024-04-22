package com.jetbrains.mufaddal.ApplicationLauncher.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jetbrains.mufaddal.ApplicationLauncher.ApplicationLauncher;
import com.jetbrains.mufaddal.ApplicationLauncher.service.InvoiceService;
import com.jetbrains.mufaddal.ApplicationLauncher.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@Configuration
public class MyFancyPdfInvoicesApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
