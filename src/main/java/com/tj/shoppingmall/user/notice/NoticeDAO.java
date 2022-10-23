package com.tj.shoppingmall.user.notice;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NoticeDAO {

    @Autowired
    SqlSession sqlSession;
    private String ns = "noticesql.";

    public List<NoticeDTO> selectNotice(Integer page, Integer pagesize) {
        Map<String, Object> m = new HashMap();
        m.put("page", page);
        m.put("pagesize",pagesize);
        return sqlSession.selectList(ns+"selectNotice",m);
    }
    public Integer selectCnt(String search) {
        return sqlSession.selectOne(ns+"selectCnt",search);
    }
    public List<NoticeDTO> searchNotice(Integer page, Integer pagesize, String option, String search) {

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("search", search);
        m.put("option", option);
        m.put("page", page);
        m.put("pagesize", pagesize);
        return sqlSession.selectList(ns+"searchNotice",m);
    }

    public int updatecnt(Integer idx) {

        return sqlSession.update(ns+"updatecnt",idx);
    }

}
