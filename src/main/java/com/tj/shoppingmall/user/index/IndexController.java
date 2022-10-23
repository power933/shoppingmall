package com.tj.shoppingmall.user.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

    @RequestMapping("/")
    public String mainpage(){
        return "index/index";
    }
}
