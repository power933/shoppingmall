package com.tj.shoppingmall;

import com.tj.shoppingmall.user.mapper.NoticeMapper;
import com.tj.shoppingmall.user.notice.NoticeDTO;
import com.tj.shoppingmall.user.notice.NoticeRequestDTO;
import com.tj.shoppingmall.user.notice.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NoticeTest {
    @Autowired
    NoticeService noticeService;
    @Autowired
    NoticeMapper noticeMapper;

    @Test
    public void searchTest(){
        NoticeRequestDTO noticeRequestDTO = NoticeRequestDTO.builder()
                .startPage(0)
                .pageEa(10)
                .searchWord("")
                .searchType("w")
                .build();
        List<NoticeDTO> list = noticeService.getSearch(noticeRequestDTO);
        System.out.println("list = " + list);
    }
    @Test
    public void qwe(){
        NoticeRequestDTO noticeRequestDTO = NoticeRequestDTO.builder()
                .startPage(0)
                .pageEa(10)
                .searchWord("")
                .searchType("n")
                .build();
        Integer list = noticeService.getSize(noticeRequestDTO);
        System.out.println("list = " + list);
    }
}
