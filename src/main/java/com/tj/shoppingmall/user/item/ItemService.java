package com.tj.shoppingmall.user.item;

import java.util.List;

public interface ItemService {
    public List<ItemDTO> selectAll();
    public ItemDTO selectByCode(String pcode);
}
