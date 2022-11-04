package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.ItemDTO;

import java.util.List;

public interface ItemService {
    public List<ItemDTO> selectAll();
    public ItemDTO selectByCode(String pcode);
}
