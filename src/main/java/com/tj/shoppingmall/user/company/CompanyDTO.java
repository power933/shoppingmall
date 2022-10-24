package com.tj.shoppingmall.user.company;

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
}
