package com.tj.shoppingmall.user.company;

import com.tj.shoppingmall.user.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<CompanyDTO> select() {
        return companyMapper.select();
    }
}
