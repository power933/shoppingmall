package com.tj.shoppingmall.user.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticeController {

    @Autowired
    NoticeDAO noticeDAO;

    @RequestMapping("notice")
    public String notice(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pagesize,
                         @RequestParam(defaultValue = "") String search,
                         @RequestParam(defaultValue = "W") String option
            , Model model) {

        /*Integer spage = (page-1)*pagesize;
        int totalea = noticeDAO.selectCnt(search);
        int pageea = (int)Math.ceil((double)totalea/pagesize);
        List<NoticeDTO> al = null;
        al = option.equals("W")&&search.equals("") ? noticeDAO.selectNotice(spage,pagesize) : noticeDAO.searchNotice(spage, pagesize, option, search);*/

//		dn.updatecnt(page);


        return "notice/notice";
    }
}
