package com.tj.shoppingmall.user.mapper;

import com.tj.shoppingmall.user.domain.CartDTO;
import com.tj.shoppingmall.user.domain.CartMemberDTO;
import com.tj.shoppingmall.user.domain.CartProductDTO;
import org.apache.ibatis.annotations.Delete;
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
    @Select("select c.cartId,m.mid,m.mname, m.memail, m.mtel, m.maddrnum,m.maddr,m.maddrdetail from cart c, members m where c.mid = m.mid and c.mid = #{mid} group by c.mid")
    List<CartMemberDTO> getMemberList(String mid);
    @Delete("delete from cart where cartId = #{cartId}")
    int deleteCart(Integer cartId);

    @Select("select * from cart where mid = #{mid}")
    List<CartDTO> getCartByMid(String mid);
}
