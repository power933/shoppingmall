package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.cs.CsDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsMapper {

    @Select("SELECT * FROM faq where fcategory = #{fcategory}")
    public List<CsDTO> findByCate(String fcategory);
}
