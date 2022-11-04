package com.tj.shoppingmall.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class GuideController {

    @RequestMapping("/guide")
    public String item(){
        return "guide/guide";
    }
}
