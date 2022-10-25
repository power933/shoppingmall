package com.tj.shoppingmall.user.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {

    @Autowired
    LoginService loginService;
    @RequestMapping("/login")
    public String view(){

        return "login/member_login";
    }
    @PostMapping("/loginck")
    public String login(String mid, String mpass){

        return loginService.login(mid,mpass)?"index/index":"redirect:login/member_login";

    }
}
