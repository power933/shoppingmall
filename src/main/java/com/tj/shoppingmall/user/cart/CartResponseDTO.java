package com.tj.shoppingmall.user.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponseDTO {
    private Integer cartId;
    private String mid;
    private String mname;
    private String memail;
    private String mtel;
    private String addr;
}
