package com.tj.shoppingmall.user.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller

public class IndexController {

    @Autowired
    IndexService indexService;
    @GetMapping({"/{cate}","/"})
    public String mainpage(Model model, @PathVariable(required = false) Optional<String> cate){
        String totalCate = cate.isPresent() ? cate.get():"0101";
        model.addAttribute("cate",indexService.getCategoryAll());
        model.addAttribute("items",indexService.getItemByCategory(totalCate));
        return "index/index";
    }
}
