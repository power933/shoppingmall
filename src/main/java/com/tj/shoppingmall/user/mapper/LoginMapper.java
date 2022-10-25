package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.login.LoginDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    @Select("select mid,mpass from members where mid=#{mid}")
    public LoginDTO selectById(String mid);
}
