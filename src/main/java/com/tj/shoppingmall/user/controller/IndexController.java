package com.tj.shoppingmall.user.controller;

import com.tj.shoppingmall.user.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller

public class IndexController {

    @Autowired
    IndexService indexService;
    @GetMapping({"/{cate}","/"})
    public String mainpage(Model model, @PathVariable(required = false) Optional<String> cate){
        String totalCate = cate.isPresent() ? cate.get():"0101";
        model.addAttribute("cate",indexService.getCategoryAll());   //카테고리 리스트
        model.addAttribute("items",indexService.getItemByCategory(totalCate));     //카테고리별 아이템 리스트
        model.addAttribute("recent",indexService.getItemOrderByIndate());   //최신상품 리스트
        model.addAttribute("best",indexService.getItemOrderByPsales()); //판매순 리스트

        return "index/index";
    }
}
