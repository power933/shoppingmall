package com.tj.shoppingmall.user.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ItemController {

    @RequestMapping("/item")
    public String item(){
        return "item/item";
    }
}
