package com.tj.shoppingmall;


import com.tj.shoppingmall.user.item.ItemDTO;
import com.tj.shoppingmall.user.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderTest {
    @Autowired
    OrderService orderService;

    @Test
    public void getPcodeTest(){
        String[] list = {"115357","111555"};
        List<ItemDTO> itemDTO = orderService.getItemByPcode(list);
        System.out.println("itemDTO = " + itemDTO);
    }
}
