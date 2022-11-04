package com.tj.shoppingmall;

import com.tj.shoppingmall.user.domain.LoginDTO;
import com.tj.shoppingmall.user.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {

    @Autowired
    LoginService loginService;

    @Test
    public void LoginTest(){
        Boolean b= loginService.login("testId112", "123");
        System.out.println("b = " + b);
    }
    @Test
    public void selectById(){
        LoginDTO loginDTO = loginService.selectById("tes112");
        System.out.println(loginDTO);
    }
}
