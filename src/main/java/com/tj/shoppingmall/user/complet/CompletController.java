package com.tj.shoppingmall.user.complet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompletController {
    @RequestMapping("/complet")
    public String view(){


        return "complet/complet";
    }
}
