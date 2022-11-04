package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.CompanyDTO;
import com.tj.shoppingmall.user.domain.IndexCategoryDTO;
import com.tj.shoppingmall.user.domain.ItemDTO;
import com.tj.shoppingmall.user.mapper.CompanyMapper;
import com.tj.shoppingmall.user.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    IndexMapper indexMapper;
    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<IndexCategoryDTO> getCategoryAll(){
        return indexMapper.getCategoryAll();
    }
    @Override
    public List<ItemDTO> getItemOrderByIndate(){
        return indexMapper.getProductOrderByIndate();
    }

    @Override
    public List<ItemDTO> getItemOrderByPsales(){
        return indexMapper.getProductOrderByPsales();
    }

    @Override
    public List<ItemDTO> getItemByCategory(String totalCate) {
        String largeCate = totalCate.substring(0,2);
        String smallCate = totalCate.substring(2,totalCate.length());

        return indexMapper.getItemByCategory(largeCate,smallCate);
    }

    @Override
    public List<CompanyDTO> select() {
        return companyMapper.select();
    }


}
