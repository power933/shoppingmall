package com.tj.shoppingmall.user.login;

import com.tj.shoppingmall.user.join.JoinRequestDTO;
import com.tj.shoppingmall.user.join.JoinService;
import com.tj.shoppingmall.user.util.SetAlert;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@AllArgsConstructor
public class LoginController {

    private JoinService joinService;
    LoginService loginService;
    @RequestMapping("/login")
    public String view(){

        return "login/member_login";
    }
    @PostMapping("/loginck")//id,pw체크
    public RedirectView login(String mid, String mpass, HttpServletRequest request, HttpServletResponse response) throws IOException{

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
            SetAlert.alert(response,"로그인 실패");
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

    @RequestMapping(value = "/klogin", method = RequestMethod.GET)//카카오로그인
    public String redirectkakao(@RequestParam String code, HttpSession session) throws IOException {
        System.out.println("code:: " + code);

        // 접속토큰 get
        String kakaoToken = loginService.getReturnAccessToken(code);
        System.out.println("kakaoToken = " + kakaoToken);
        // 접속자 정보 get
        Map<String, Object> result = loginService.getUserInfo(kakaoToken);
        //log.info("result:: " + result);
        String snsId = (String) result.get("id");
        String userName = (String) result.get("nickname");
        String email = (String) result.get("email");
        String userpw = snsId;

        if (loginService.selectById(email) == null) {
            JoinRequestDTO dto = JoinRequestDTO.builder()
                    .mid(email)
                    .mpass(userpw)
                    .mname(userName)
                    .memail0(email.split("@")[0])
                    .memail1(email.split("@")[1])
                    .mtel0("")
                    .mtel1("")
                    .mtel2("")
                    .maddr("")
                    .maddrnum("")
                    .maddrdetail("")
                    .build();
            joinService.insertMember(dto);
        }

        session.setAttribute("user",joinService.selectById(email));


        return "redirect:/";

    }

}
