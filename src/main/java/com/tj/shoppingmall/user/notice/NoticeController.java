package com.tj.shoppingmall.user.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping("notice")
    public String notice(
            @ModelAttribute("dto") NoticeRequestDTO noticeRequestDTO
            , Model model) {


        List<NoticeDTO> list = noticeService.getSearch(noticeRequestDTO);
        model.addAttribute("list",list);
        int size = noticeService.getSize(noticeRequestDTO);
        //총합사이즈 : 서치가 진행되지 않았으면 총 게시물 갯수로 사이즈 잡고 아니면 서치된 게시물 갯수로 잡음
        int pageea = (int)Math.ceil((double)size/ noticeRequestDTO.getPageEa());
        model.addAttribute("size",pageea);

        return "notice/notice";
    }
}
