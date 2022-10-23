package com.tj.shoppingmall.user.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CartController {

    @RequestMapping("/cart")
    public String item(){
        return "cart/ordercart";
    }
}
