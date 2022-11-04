package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.CsDTO;

import java.util.List;

public interface CsService {
    List<CsDTO> findByCate(String fcategory);
}
