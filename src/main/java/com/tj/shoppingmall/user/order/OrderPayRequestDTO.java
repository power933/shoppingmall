package com.tj.shoppingmall.user.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPayRequestDTO {
    private String ordernum;
    private String mid;
    private String cname;
    private String chp1;
    private String chp2;
    private String chp3;
    private String ctel1;
    private String ctel2;
    private String ctel3;
    private String person_nm;
    private String person_post;
    private String person_addr;
    private String person_addrtc;
    private String[] person_hp;
    private String[] person_phone;
    private String recipient_email;
    private String msg;
    private String payment;
    private String[] pcode;
    private int[] count;
    private int[] priceeach;
    private String[] pname;
    private String[] pimg1;
    private LocalDateTime orderdate;
}
