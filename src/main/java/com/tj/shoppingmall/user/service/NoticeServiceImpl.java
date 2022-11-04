package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.NoticeDTO;
import com.tj.shoppingmall.user.domain.NoticeRequestDTO;
import com.tj.shoppingmall.user.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements  NoticeService{

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<NoticeDTO> getSearch(NoticeRequestDTO noticeRequestDTO) {
        NoticeRequestDTO dto = settingDTO(noticeRequestDTO);

        return noticeRequestDTO.getSearchType().equals("w")?
                noticeMapper.getAllSearch(dto)
                :  noticeMapper.getTypeSearch(dto);
    }

    public int getSize(NoticeRequestDTO noticeRequestDTO){
        NoticeRequestDTO dto = settingDTO(noticeRequestDTO);
        return noticeRequestDTO.getSearchType().equals("y")?
                noticeMapper.getYSize(dto)
                :  noticeMapper.getSize(dto);
    }


}
