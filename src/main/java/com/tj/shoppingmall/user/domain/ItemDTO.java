package com.tj.shoppingmall.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Integer idx;
    private String plarge_cate;
    private String psmall_cate;
    private String pcode;
    private String pname;
    private String psub_ex;
    private String pprice;
    private String ppercent;
    private String psale;
    private String pstock;
    private String puse;
    private String psoldout;
    private String p_ex;
    private String pimg1;
    private String pimg2;
    private String pimg3;

}
