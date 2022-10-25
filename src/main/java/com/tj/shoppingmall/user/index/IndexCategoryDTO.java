package com.tj.shoppingmall.user.index;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndexCategoryDTO {
    private String ctotal_cate;
    private String clarge_cate;
    private String clarge_name;
    private String csmall_cate;
    private String csmall_name;

}
