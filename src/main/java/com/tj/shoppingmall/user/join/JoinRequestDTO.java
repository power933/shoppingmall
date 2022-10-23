package com.tj.shoppingmall.user.join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinRequestDTO {
    private String mid;
    private String mpass;
    private String mname;
    private String memail0;
    private String memail1;
    private String mtel0;
    private String mtel1;
    private String mtel2;
    private String maddr0;
    private String maddr1;
    private String maddr2;
}
