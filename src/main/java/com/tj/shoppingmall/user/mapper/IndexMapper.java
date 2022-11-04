package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.domain.IndexCategoryDTO;
import com.tj.shoppingmall.user.domain.ItemDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexMapper {
    @Select("select * from category where cuse='Y' limit 4")
    List<IndexCategoryDTO> getCategoryAll();

    @Select("select * from product " +
            "where plarge_cate=#{plarge_cate} " +
            "and psmall_cate=#{psmall_cate} limit 16")
    List<ItemDTO> getItemByCategory(String plarge_cate, String psmall_cate);

    @Select("select * from product order by psales desc limit 8")
    List<ItemDTO> getProductOrderByPsales();

    @Select("select * from product order by indate desc limit 6")
    List<ItemDTO> getProductOrderByIndate();
}
