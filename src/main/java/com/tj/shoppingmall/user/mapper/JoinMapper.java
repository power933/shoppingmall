package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.join.JoinDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinMapper {

    @Select("select * from members")
    public List<JoinDTO> getAll();
    @Insert("insert into members" +
            " values(#{mid},#{mpass},#{mname},#{memail}," +
            "#{mtel},#{maddrnum},#{maddr},#{maddrdetail},#{indate})")
    public int memberInsert(JoinDTO joinDTO);

    @Select("select * from members where mid = #{mid}")
    public JoinDTO findById(String mid);

    @Select("select * from members where memail = #{memail}")
    public JoinDTO findByEmail(String memail);
}
