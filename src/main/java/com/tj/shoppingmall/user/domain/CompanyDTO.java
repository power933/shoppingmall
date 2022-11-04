package com.tj.shoppingmall.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    private String spost;
    private String saddr;
    private String scompany_name;
    private String stel;
    private String stitle;
    private String semail;
    private String sres_name;
    private String sbank_name;
    private String sbank_num;
    private String suse_tel;
    private String suse_book;
    private String sdelivery_name;
    private String sdelivery_payment;
    private String suse_hopedate;
    private String sbn;
}
