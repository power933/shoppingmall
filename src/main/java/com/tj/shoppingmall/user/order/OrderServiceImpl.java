package com.tj.shoppingmall.user.order;

import com.tj.shoppingmall.user.item.ItemDTO;
import com.tj.shoppingmall.user.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<ItemDTO> getItemByPcode(String pcode[]){
        List<String> list = new ArrayList<String>(Arrays.asList(pcode));
        List<ItemDTO> result = new ArrayList<>();
        list.stream().forEach(i->{
            result.add(itemMapper.selectByCode(i));
        });
        return result;
    }

}
