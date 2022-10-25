package com.tj.shoppingmall;

import com.tj.shoppingmall.user.item.ItemDTO;
import com.tj.shoppingmall.user.item.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemTest {

    @Autowired
    ItemService itemService;

    @Test
    public void selectTest(){
        List<ItemDTO> list = itemService.selectAll();
        System.out.println("list = " + list);
        ItemDTO dto = itemService.selectByCode("111555");
        System.out.println(dto);
    }
}
