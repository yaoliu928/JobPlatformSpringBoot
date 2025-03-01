package com.mycompany.jobspringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController // @Controller and @ResponseBody
@ConfigurationProperties(prefix = "manager")
public class DemoController {
    private String name;
    private String hobby;

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    // handle get request
    @GetMapping("/get/userinfo")
    // make method return value to be the response
    @ResponseBody
    public String getUseInfo(
            @RequestParam(value="nickname",required = true) String nickname,
            @RequestParam(value="age") String age
    ) {
        return "Hello " + nickname + ", you are " + age;
    }

    // post request
    @PostMapping("/login")
    public String login(){

        return "login success";
    }

    @GetMapping("/get/propvalue")
    public void getPropertiesValue(@Value("${server.port}") String port){
        System.out.println("port is "+port);
        System.out.println("name is "+name);
        System.out.println("hobby is "+hobby);
    }
}