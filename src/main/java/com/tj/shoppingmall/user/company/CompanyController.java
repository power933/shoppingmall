package com.tj.shoppingmall.user.company;

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

