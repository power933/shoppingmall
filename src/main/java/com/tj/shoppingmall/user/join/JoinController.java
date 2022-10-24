package com.tj.shoppingmall.user.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String joinMember(JoinRequestDTO joinRequestDTO){

        int result = joinService.updateMember(joinRequestDTO);
        if(result>0){
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

