package com.mycompany.jobspringboot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("招聘网可视化分析系统")
                        .description("后端接口文档")
                        .version("2.0")
                        .license(new License().name("慕课网").url("https://www.imooc.com/")));
    }
}