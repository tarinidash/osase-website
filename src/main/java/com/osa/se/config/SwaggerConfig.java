package com.osa.se.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by tarinidash on 3/2/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Predicate<String> paths() {
        return or(
                regex("/event.*"),
                regex("/family.*"),
                regex("/ledger.*"),
                regex("/member.*"),
                regex("/payment.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("OSA-SE")
                .description("SAMPLE DESCRIPTION")
                .version("1.0")
                .contact(new Contact("OSA-SE OFFICE BEARERS", "", "osase_office+noreply@googlegroups.com"))
                .build();
    }

    /**
     * Create spring-mvc plugin docket.
     *
     * @return the docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("OSA-SE APIs")
                .apiInfo(apiInfo())
                .select()
                .paths(paths())
                .build();
    }

}
