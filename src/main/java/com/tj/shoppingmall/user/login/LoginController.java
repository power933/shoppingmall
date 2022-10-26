package com.tj.shoppingmall.user.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView login(String mid, String mpass, HttpServletRequest request){

        RedirectView redirectView = new RedirectView();

        if(loginService.login(mid,mpass)){
            HttpSession session = request.getSession();
            session.setAttribute("user",loginService.selectById(mid));
            session.setMaxInactiveInterval(60*60*12);
            redirectView.setUrl("/");
            return redirectView;
        }
        else{
            redirectView.setUrl("/login");
            return redirectView;
        }
    }

    @RequestMapping ("/logout")
    public RedirectView logout(HttpServletRequest request){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        HttpSession session = request.getSession(false);
        session.invalidate();

        return redirectView;
    }

}
