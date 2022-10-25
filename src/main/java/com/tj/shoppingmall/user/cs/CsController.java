package com.tj.shoppingmall.user.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller

public class CsController {

    @Autowired
    CsService csService;

    @RequestMapping({"/cs","/cs/{category}"})
    public String item(Model model, HttpServletRequest request, @PathVariable Optional<String> category){
        String cate = category.isPresent()? category.get():"1";
        String[] menu = {"배송안내","반품/교환안내","상품안내","쿠폰안내","마일리지안내","자주묻는질문"};
        String url = request.getContextPath();
        model.addAttribute("url",url);
        model.addAttribute("list",csService.findByCate(cate));
        model.addAttribute("menu",menu);

        return "cs/cs";
    }
}
