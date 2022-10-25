package com.tj.shoppingmall;

import com.tj.shoppingmall.user.index.IndexCategoryDTO;
import com.tj.shoppingmall.user.index.IndexService;
import com.tj.shoppingmall.user.item.ItemDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IndexTest {

    @Autowired
    IndexService indexService;
    @Test
    public void categoryGetTest(){
        List<IndexCategoryDTO> indexCategoryDTO = indexService.getCategoryAll();
        System.out.println(indexCategoryDTO);
    }

    @Test
    public void getItemBycateTest(){
        List<ItemDTO> item = indexService.getItemByCategory("0102");
        System.out.println("item = " + item);
    }

    @Test
    public void getOrderBy(){
        List<ItemDTO> item = indexService.getItemOrderByPsales();
        List<ItemDTO> item2 = indexService.getItemOrderByIndate();
        System.out.println(item2);
        System.out.println(item);
    }
}
