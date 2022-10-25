package com.tj.shoppingmall;

import com.tj.shoppingmall.user.cart.CartProductDTO;
import com.tj.shoppingmall.user.cart.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CartTest {
    
    @Autowired
    CartService cartService;
    
    @Test
    public void cartInsert(){
        int a = cartService.insertCart("test","111555","1");
        System.out.println("a = " + a);
    }
    @Test
    public void CartSelect(){
        List<CartProductDTO> list = cartService.getCartList("testid");
        System.out.println("list = " + list);
    }
}
