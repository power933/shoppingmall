package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.join.JoinDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinMapper {

    @Select("select * from member")
    public List<JoinDTO> getAll();
    @Insert("insert into member" +
            " values(#{mid},#{mpass},#{mname},#{memail}," +
            "#{mtel},#{maddr})")
    public int memberUpdate(JoinDTO joinDTO);
}
