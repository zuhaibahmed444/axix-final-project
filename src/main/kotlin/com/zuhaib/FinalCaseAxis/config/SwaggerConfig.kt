package com.zuhaib.FinalCaseAxis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.util.*

@Configuration
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
    }
    private fun apiInfo(): ApiInfo {
        return ApiInfo(
                "E-library",
                "Implementation of E-library.",
                "1.0",
                "Terms of service",
                Contact("Zuhaib Ahmed", "www.abc.com", "Zuhaibahmed444@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        )
    }

}