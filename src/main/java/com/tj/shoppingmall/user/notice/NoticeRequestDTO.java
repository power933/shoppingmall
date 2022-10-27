package com.tj.shoppingmall.user.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeRequestDTO {
    @Builder.Default
    private Integer startPage = 1;
    @Builder.Default
    private Integer pageEa = 10;
    @Builder.Default
    private String searchWord = "";
    @Builder.Default
    private String searchType = "w";

}
