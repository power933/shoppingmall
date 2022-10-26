package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.notice.NoticeDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    @Select("select * from notice where ntitle like concat('%',#{searchWord},'%') and nuse_notice='y' union all (select * from notice where ntitle like concat('%',#{searchWord},'%') and nuse_notice='n' order by idx desc limit #{startPage},#{pageEa})")
    List<NoticeDTO>  getAllSearch(int startPage, int pageEa, String searchWord);

    @Select(
            "(select * from notice where ntitle like concat('%',#{searchWord},'%') and nuse_notice=#{searchType} order by idx desc limit #{startPage},#{pageEa})")
    List<NoticeDTO>  getTypeSearch(int startPage, int pageEa, String searchWord, String searchType);
}
