package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.CsDTO;
import com.tj.shoppingmall.user.mapper.CsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsServiceImpl implements CsService{

    @Autowired
    CsMapper csMapper;

    @Override
    public List<CsDTO> findByCate(String fcategory) {
        return csMapper.findByCate(fcategory);
    }
}
