package com.jetbrains.mufaddal.ApplicationLauncher.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jetbrains.mufaddal.ApplicationLauncher.ApplicationLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@Configuration
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties"
        , ignoreResourceNotFound = true)
@EnableWebMvc
public class ApplicationConfiguration {

    @Bean // for request param validation
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    /*
     * Whenever you return a String from a @Controller like "return index.html", Spring will ask all the ViewResolvers it knows to find and render that index.html view/template. Hence, you need to declare a ThymeleafViewResolver, so Spring knows about it.
     * */
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());

        viewResolver.setOrder(1); // optional
        viewResolver.setViewNames(new String[]{"*.html", "*.xhtml"}); // optional
        return viewResolver;
    }

    /*
     * The ViewResolver needs a SpringTemplateEngine to work with, a Thymeleaf-specific configuration bean. It lets you configure a couple of more advanced Thymeleaf settings, but it also needs a reference to a templateResolver, the class that actually finds your Thymeleaf template.
     * */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    /*
     * Here you are saying that all your templates should be in the /templates/ folder on your classpath (i.e. src/main/resources/ during development, later on in the .jar file) and that they should not be cached, which makes sense during development, but not in production.
     * */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
}
