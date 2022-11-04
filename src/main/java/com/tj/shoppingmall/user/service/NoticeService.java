package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.NoticeDTO;
import com.tj.shoppingmall.user.domain.NoticeRequestDTO;

import java.util.List;

public interface NoticeService {


    List<NoticeDTO> getSearch(NoticeRequestDTO noticeRequestDTO);
    int getSize(NoticeRequestDTO noticeRequestDTO);

    default NoticeRequestDTO settingDTO(NoticeRequestDTO noticeRequestDTO){
        NoticeRequestDTO newDTO = NoticeRequestDTO.builder()
                .searchWord(noticeRequestDTO.getSearchWord().trim())
                .searchType(noticeRequestDTO.getSearchType())
                .pageEa(noticeRequestDTO.getPageEa())
                .startPage((noticeRequestDTO.getStartPage()-1)*noticeRequestDTO.getPageEa())
                .build();
        return newDTO;
    }

}
