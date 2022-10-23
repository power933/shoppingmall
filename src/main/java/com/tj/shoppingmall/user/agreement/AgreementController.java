package com.tj.shoppingmall.user.agreement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AgreementController {

    @RequestMapping("/agreement")
    public String item(){
        return "agreement/agreement";
    }
}
