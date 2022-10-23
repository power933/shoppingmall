package com.tj.shoppingmall.user.join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JoinDTO {
    private String mid;
    private String mpass;
    private String mname;
    private String memail;
    private String mtel;
    private String maddr;


}
