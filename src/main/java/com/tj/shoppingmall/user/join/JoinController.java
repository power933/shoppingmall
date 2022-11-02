package com.tj.shoppingmall.user.join;

import com.tj.shoppingmall.user.util.SetAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class JoinController {

    @Autowired
    JoinService joinService;

    @RequestMapping("/join")
    public String join(JoinRequestDTO joinRequestDTO){
        return "join/member";
    }
    @RequestMapping("/join-member")
    public String joinMember(JoinRequestDTO joinRequestDTO, HttpServletResponse response) throws IOException {

        int result = joinService.insertMember(joinRequestDTO);
        if(result>0){
            SetAlert.alertAndMovePage(response,"축하합니다 회원가입에 성공하셨습니다","/");
            return "index/index";
        }
        else{
            return "join/member";
        }
    }
    @GetMapping("/join-idcheck")
    @ResponseBody
    public Map<String, Boolean> idcheck(String mid){
        Map<String, Boolean> map = new HashMap<>();
        boolean result = joinService.selectById(mid)==null?true:false;

        map.put("result",result);

        return map;
    }

    @GetMapping("/join-emailcheck")
    @ResponseBody
    public Map<String, Boolean> emailcheck(String memail){
        Map<String, Boolean> map = new HashMap<>();
        boolean result = joinService.selectByEmail(memail)==null?true:false;

        map.put("result",result);

        return map;
    }



}

