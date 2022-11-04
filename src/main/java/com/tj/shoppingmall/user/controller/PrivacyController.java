package com.tj.shoppingmall.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class PrivacyController {

    @RequestMapping("/privacy")
    public String item(){
        return "privacy/privacy";
    }
}
