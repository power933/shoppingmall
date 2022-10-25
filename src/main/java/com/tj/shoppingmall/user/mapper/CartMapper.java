package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.cart.CartDTO;
import com.tj.shoppingmall.user.cart.CartProductDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper {

    @Insert("insert into cart values('0',#{mid},#{pcode},#{product_count})")
    int insertCart(String mid, String pcode, String product_count);
    @Select("select * from cart c, product p where c.pcode = p.pcode and c.mid=#{mid}")
    List<CartProductDTO> getCartList(String mid);
}
