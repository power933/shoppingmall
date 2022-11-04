package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.CompanyDTO;
import com.tj.shoppingmall.user.domain.IndexCategoryDTO;
import com.tj.shoppingmall.user.domain.ItemDTO;

import java.util.List;

public interface IndexService {
    List<IndexCategoryDTO> getCategoryAll();
    List<ItemDTO> getItemByCategory(String totalCate);
    public List<ItemDTO> getItemOrderByIndate();
    public List<ItemDTO> getItemOrderByPsales();
    public List<CompanyDTO> select();
}
