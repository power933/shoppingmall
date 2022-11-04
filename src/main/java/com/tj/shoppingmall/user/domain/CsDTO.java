package com.tj.shoppingmall.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CsDTO {
    private Integer fidx;
    private String fcategory;
    private String fname;
    private String fquestion;
    private String fanswer;
    private String fdate;
    private String fcheck;
}
