package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.ItemDTO;
import com.tj.shoppingmall.user.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<ItemDTO> selectAll(){
        return itemMapper.selectAll();
    }
    @Override
    public ItemDTO selectByCode(String pcode){
        return itemMapper.selectByCode(pcode);
    }

}
