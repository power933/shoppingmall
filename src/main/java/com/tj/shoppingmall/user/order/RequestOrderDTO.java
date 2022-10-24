package com.tj.shoppingmall.user.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestOrderDTO {
    private String product_nm;
    private String product_dtc;
    private String price;
    private String point;
    private String total;
    private String product_ea;
}
