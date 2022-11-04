package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.CartDTO;
import com.tj.shoppingmall.user.domain.CartProductDTO;
import com.tj.shoppingmall.user.domain.CartResponseDTO;
import com.tj.shoppingmall.user.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CartResponseDTO> getMemberList(String mid){

        List<CartResponseDTO> cartResponseDTO = getToResponse(cartMapper.getMemberList(mid));
        return cartResponseDTO;
    }

    @Override
    public List<CartDTO> getCartByMid(String mid) {
        return cartMapper.getCartByMid(mid);
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
