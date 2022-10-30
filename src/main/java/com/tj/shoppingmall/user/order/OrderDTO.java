package com.tj.shoppingmall.user.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private String ordernum;
    private String mid;
    private String mname;
    private String mhp;
    private String mtel;
    private String memail;
    private String paytype;
    private String uname;
    private String uaddr;
    private String uhp;
    private String utel;
    private String umsg;
    private int pprice;
    private String pcode;
    private int product_count;
    private LocalDateTime orderdate;
}
