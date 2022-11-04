package com.tj.shoppingmall.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartMemberDTO {
    private Integer cartId;
    private String mid;
    private String mname;
    private String memail;
    private String mtel;
    private String maddrnum;
    private String maddr;
    private String maddrdetail;
}
