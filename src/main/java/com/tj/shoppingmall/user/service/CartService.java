package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.CartDTO;
import com.tj.shoppingmall.user.domain.CartMemberDTO;
import com.tj.shoppingmall.user.domain.CartProductDTO;
import com.tj.shoppingmall.user.domain.CartResponseDTO;

import java.util.ArrayList;
import java.util.List;

public interface CartService {
    public int insertCart(String mid, String pcode, String product_count);
   List<CartProductDTO> getCartList(String mid);
   Boolean deleteCart(List<Integer> cartId);
   public List<CartResponseDTO> getMemberList(String mid);
   List<CartDTO> getCartByMid(String mid);

   default List<CartResponseDTO> getToResponse(List<CartMemberDTO> list){

       List<CartResponseDTO> result = new ArrayList<>();
       list.stream().forEach(dto->{
           CartResponseDTO cartResponseDTO = CartResponseDTO.builder()
                   .cartId(dto.getCartId())
                   .mid(dto.getMid())
                   .mname(dto.getMname())
                   .memail(dto.getMemail())
                   .mtel(dto.getMtel())
                   .addr(dto.getMaddrnum()+" "+dto.getMaddr()+" "+dto.getMaddrdetail())
                   .build();
           result.add(cartResponseDTO);
       });

       return result;
   }


}