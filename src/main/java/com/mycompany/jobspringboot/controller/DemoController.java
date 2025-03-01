package com.mycompany.jobspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController // @Controller and @ResponseBody
public class DemoController {
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

    @PostMapping("/login")
    public String login(){

        return "login success";
    }
}