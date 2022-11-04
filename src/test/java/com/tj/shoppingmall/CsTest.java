package com.tj.shoppingmall;

import com.tj.shoppingmall.user.domain.CsDTO;
import com.tj.shoppingmall.user.service.CsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CsTest {
    @Autowired
    CsService csService;

    @Test
    public void csserviceTest(){
        List<CsDTO> list = csService.findByCate("1");
        System.out.println("list = " + list);
    }
}
