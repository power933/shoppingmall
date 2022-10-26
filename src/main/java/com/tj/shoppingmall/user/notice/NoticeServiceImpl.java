package com.tj.shoppingmall.user.notice;

import com.tj.shoppingmall.user.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements  NoticeService{

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<NoticeDTO> getAllSearch(int startPage, int pageEa, String searchWord) {
        return noticeMapper.getAllSearch(startPage,pageEa,searchWord);
    }

    @Override
    public List<NoticeDTO> getTypeSearch(int startPage, int pageEa, String searchWord, String searchType) {
        return noticeMapper.getTypeSearch(startPage,pageEa,searchWord,searchType);
    }
}
