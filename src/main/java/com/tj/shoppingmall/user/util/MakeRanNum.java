package com.tj.shoppingmall.user.util;

import com.tj.shoppingmall.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRanNum {

    @Autowired
    CartService cartService;

    public String makeRandomNumber(){
        int res = (int)(Math.random()*1000000);
        String result = String.valueOf(res);
        if(cartService.getCartByMid(result)!=null)
            return result;
        else
            return makeRandomNumber();
    }
}
