package com.tj.shoppingmall.user.index;

import com.tj.shoppingmall.user.item.ItemDTO;

import java.util.List;

public interface IndexService {
    List<IndexCategoryDTO> getCategoryAll();
    List<ItemDTO> getItemByCategory(String totalCate);
}
