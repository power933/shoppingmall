package com.tj.shoppingmall.user.cart;

import java.util.List;

public interface CartService {
    public int insertCart(String mid, String pcode, String product_count);
   List<CartProductDTO> getCartList(String mid);
}