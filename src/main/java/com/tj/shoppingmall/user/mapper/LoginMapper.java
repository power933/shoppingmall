package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.domain.LoginDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    @Select("select mid,mpass,mname from members where mid=#{mid}")
    public LoginDTO selectById(String mid);
}
