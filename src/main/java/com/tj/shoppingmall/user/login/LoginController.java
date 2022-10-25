package com.tj.shoppingmall.user.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller

public class LoginController {

    @Autowired
    LoginService loginService;
    @RequestMapping("/login")
    public String view(){

        return "login/member_login";
    }
    @PostMapping("/loginck")
    public String login(String mid, String mpass, HttpServletRequest request){

        if(loginService.login(mid,mpass)){
            HttpSession session = request.getSession();
            session.setAttribute("user",loginService.selectById(mid));
            return "index/index";
        }
        else{
            return "redirect:login";
        }
    }

    @RequestMapping ("/logout")
    public String logout(HttpServletRequest request){

        HttpSession session = request.getSession(false);
        session.invalidate();

        return "index/index";
    }
}
