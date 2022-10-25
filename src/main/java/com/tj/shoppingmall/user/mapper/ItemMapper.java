package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.item.ItemDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMapper {
    @Select("select * from product")
    List<ItemDTO> selectAll();

    @Select("select * from product where pcode=#{pcode}")
    ItemDTO selectByCode(String pcode);
}
