package com.tj.shoppingmall.user.order;

import com.tj.shoppingmall.user.item.ItemDTO;

import java.util.List;

public interface OrderService {
    public List<ItemDTO> getItemByPcode(String pcode[]);
}
