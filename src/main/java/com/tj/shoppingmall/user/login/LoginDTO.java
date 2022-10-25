package com.tj.shoppingmall.user.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {
    private String mid;
    private String mpass;
    private String mname;
    private String memail;
    private String mtel;
    private String maddrnum;
    private String maddr;
    private String maddrdetail;

}
