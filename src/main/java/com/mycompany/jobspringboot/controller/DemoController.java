package com.mycompany.jobspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    // handle get request
    @GetMapping("/get/userinfo")
    // make method return value to be the response
    @ResponseBody
    public String getUseInfo(@RequestParam(value="nickname",required = true) String nickname) {
        return "Hello " + nickname + "!";
    }
}