package com.tj.shoppingmall;

import com.tj.shoppingmall.user.notice.NoticeDTO;
import com.tj.shoppingmall.user.notice.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NoticeTest {
    @Autowired
    NoticeService noticeService;

    @Test
    public void searchTest(){
        //List<NoticeDTO> list = noticeService.getAllSearch(0,5,"1");
        List<NoticeDTO> list1 = noticeService.getTypeSearch(0,5,"1","y");
        System.out.println("list1 = " + list1);
    }
}
