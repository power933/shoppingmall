package com.tj.shoppingmall;

import com.tj.shoppingmall.user.company.CompanyDTO;
import com.tj.shoppingmall.user.company.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CompanyTest {
    
    @Autowired
    CompanyService companyService;
    
    @Test
    public void selectCompany(){
        List<CompanyDTO> list = companyService.select();
        System.out.println("list.get(0).toString() = " + list.get(0).toString());
    }
}
