package com.tj.shoppingmall.user.index;

import com.tj.shoppingmall.user.company.CompanyDTO;
import com.tj.shoppingmall.user.item.ItemDTO;

import java.util.List;

public interface IndexService {
    List<IndexCategoryDTO> getCategoryAll();
    List<ItemDTO> getItemByCategory(String totalCate);
    public List<ItemDTO> getItemOrderByIndate();
    public List<ItemDTO> getItemOrderByPsales();
    public List<CompanyDTO> select();
}
