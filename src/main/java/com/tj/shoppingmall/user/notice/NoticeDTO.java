package com.tj.shoppingmall.user.notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {
    private Integer idx;
    private String nuse_notice;
    private String ntitle;
    private String nwriter;
    private String nfilurl;
    private String ncontent;
    private String ncount;
    private String ndate;
}
