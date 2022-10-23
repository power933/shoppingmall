package com.tj.shoppingmall.user.join;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {

    @RequestMapping("/join")
    public String join(JoinRequestDTO joinRequestDTO){

        JoinDTO joinDTO = JoinDTO.builder()
                .mid(joinRequestDTO.getMid())
                .mpass(joinRequestDTO.getMpass())
                .mname(joinRequestDTO.getMname())
                .memail(joinRequestDTO.getMemail0()+"@"+joinRequestDTO.getMemail1())
                .mtel(joinRequestDTO.getMtel0()+joinRequestDTO.getMtel1()+joinRequestDTO.getMtel2())
                .maddr(joinRequestDTO.getMaddr0()+joinRequestDTO.getMaddr1()+joinRequestDTO.getMaddr2())
                .build();
        return "join/member";
    }


}

