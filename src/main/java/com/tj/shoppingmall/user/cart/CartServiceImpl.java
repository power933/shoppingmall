package com.tj.shoppingmall.user.cart;

import com.tj.shoppingmall.user.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartMapper cartMapper;

    @Override
    public int insertCart(String mid, String pcode, String product_count){
        return cartMapper.insertCart(mid,pcode,product_count);
    }

    @Override
    public List<CartProductDTO> getCartList(String mid){
        return cartMapper.getCartList(mid);
    }

    @Override
    public Boolean deleteCart(List<Integer> cartId) {

        try{
            cartId.stream().forEach(i -> {
                cartMapper.deleteCart(i);
            });
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
