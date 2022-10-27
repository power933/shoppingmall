package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.notice.NoticeDTO;
import com.tj.shoppingmall.user.notice.NoticeRequestDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    @Select("select * from notice where nuse_notice='y' " +
            "union all (select * from notice where ntitle like concat('%',#{searchWord},'%') and nuse_notice='n' " +
            "order by idx desc limit #{startPage},#{pageEa}) order by nuse_notice desc, idx desc")
    List<NoticeDTO>  getAllSearch(NoticeRequestDTO noticeRequestDTO);

    @Select(
            "(select * from notice where ntitle like concat('%',#{searchWord},'%') and nuse_notice=#{searchType} order by idx desc limit #{startPage},#{pageEa})")
    List<NoticeDTO>  getTypeSearch(NoticeRequestDTO noticeRequestDTO);
    @Select("(select count(*) from notice where ntitle like concat('%',#{searchWord},'%') and nuse_notice='n')")
    Integer getSize(NoticeRequestDTO noticeRequestDTO);

    @Select("(select count(*) from notice where ntitle like concat('%',#{searchWord},'%') and nuse_notice='y')")
    Integer getYSize(NoticeRequestDTO noticeRequestDTO);

}
