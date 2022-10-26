package com.tj.shoppingmall.user.notice;

import java.util.List;

public interface NoticeService {
    List<NoticeDTO> getAllSearch(int startPage, int pageEa, String searchWord);
    List<NoticeDTO> getTypeSearch(int startPage, int pageEa, String searchWord,String searchType);
}
