package com.tj.shoppingmall;

import com.tj.shoppingmall.user.domain.CartMemberDTO;
import com.tj.shoppingmall.user.domain.CartProductDTO;
import com.tj.shoppingmall.user.domain.CartResponseDTO;
import com.tj.shoppingmall.user.service.CartService;
import com.tj.shoppingmall.user.mapper.CartMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CartTest {
    
    @Autowired
    CartService cartService;
    @Autowired
    CartMapper cartMapper;
    
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

    @Test
    public void cartDelete(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);

        System.out.println("list = " + cartService.deleteCart(list));
    }
    @Test
    public void cartJoinTest(){
        List<CartMemberDTO> cartMemberDTO = cartMapper.getMemberList("test");

        System.out.println("list = " + cartMemberDTO);
    }
    @Test
    public void cartJoinTestService(){
        List<CartResponseDTO> cartMemberDTO = cartService.getMemberList("test");

        System.out.println("list = " + cartMemberDTO);
    }
}
