package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.domain.OrderDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

@Insert("insert into orderlist values('0',#{ordernum},#{mid},#{mname},#{mhp},#{mtel},#{memail},#{paytype},#{uname},#{uaddr},#{uhp},#{utel},#{umsg},#{pprice},#{pcode},#{product_count},#{orderdate})")
    public int intsertOrder(OrderDTO orderDTO);

    @Update("update product set pstock = pstock-#{product_count}, psales=psales+#{product_count} where pcode=#{pcode}")
    public int updateStock(int product_count,String pcode);

    @Update("update members set mpoint = mpoint+#{mpoint}")
    public int updateMemberPoint(int mpoint);
}

