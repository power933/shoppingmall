package com.tj.shoppingmall.user.index;

import com.tj.shoppingmall.user.item.ItemDTO;
import com.tj.shoppingmall.user.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    IndexMapper indexMapper;

    @Override
    public List<IndexCategoryDTO> getCategoryAll(){
        return indexMapper.getCategoryAll();
    }

    @Override
    public List<ItemDTO> getItemByCategory(String totalCate) {
        String largeCate = totalCate.substring(0,2);
        String smallCate = totalCate.substring(2,totalCate.length());

        return indexMapper.getItemByCategory(largeCate,smallCate);
    }


}
