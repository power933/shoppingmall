package com.tj.shoppingmall.user.cs;

import java.util.List;

public interface CsService {
    List<CsDTO> findByCate(String fcategory);
}
