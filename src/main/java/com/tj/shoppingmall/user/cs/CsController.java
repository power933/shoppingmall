package com.tj.shoppingmall.user.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller

public class CsController {

    @Autowired
    CsService csService;

    @RequestMapping("/cs")
    public String item(Model model, HttpServletRequest request, String cate){
        String[] menu = {"배송안내","반품/교환안내","상품안내","쿠폰안내","마일리지안내","자주묻는질문"};
        String url = request.getContextPath();
        model.addAttribute("url",url);
        model.addAttribute("list",csService.findByCate(cate));
        model.addAttribute("menu",menu);

        return "cs/cs";
    }
}
