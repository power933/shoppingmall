package com.tj.shoppingmall.user.controller;

import com.tj.shoppingmall.user.domain.CompanyDTO;
import com.tj.shoppingmall.user.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CompanyController {

    @Autowired
    CompanyService companyService;
    @RequestMapping("/company")
    public String view(Model model){
        CompanyDTO companyDTO = companyService.select().get(0);
        model.addAttribute("dto", companyDTO);
        return "company/company";
    }
}

