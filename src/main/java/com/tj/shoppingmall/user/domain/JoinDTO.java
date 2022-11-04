package com.tj.shoppingmall.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private String maddrnum;
    private String maddr;
    private String maddrdetail;
    private LocalDateTime indate;
    private Integer mpoint;

}
