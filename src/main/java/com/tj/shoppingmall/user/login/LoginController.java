package com.tj.shoppingmall.user.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {

    @RequestMapping("/login")
    public String item(){
        return "login/member_login";
    }
}
