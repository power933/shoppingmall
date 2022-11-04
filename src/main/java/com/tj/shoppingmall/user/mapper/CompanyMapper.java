package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.domain.CompanyDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {
    @Select("select * from setting")
    List<CompanyDTO> select();
}
