package com.tj.shoppingmall.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private Integer cartId;
    private String mid;
    private String pcode;
    private String product_count;
}
