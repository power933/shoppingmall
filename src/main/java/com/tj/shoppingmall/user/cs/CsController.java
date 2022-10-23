package com.tj.shoppingmall.user.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CsController {

    @RequestMapping("/cs")
    public String item(){
        return "cs/cs";
    }
}
