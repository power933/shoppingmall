package com.tj.shoppingmall.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartProductDTO {
    private String mid;
    private String pcode;
    private Integer product_count;
    private String pname;
    private String psub_ex;
    private Integer pprice;
    private Integer ppercent;
    private Integer psale;
    private String pimg1;
    private Integer psales;
    private Integer cartId;
    private String plarge_cate;
    private String psmall_cate;
}
