package com.tj.shoppingmall.user.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CompanyController {

    @RequestMapping("/company")
    public String item(){
        return "company/company";
    }
}

