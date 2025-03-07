package com.mycompany.jobspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mycompany.jobspringboot.mapper")
public class JobSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobSpringBootApplication.class, args);
    }

}
