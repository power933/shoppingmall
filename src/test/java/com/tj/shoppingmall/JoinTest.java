package com.tj.shoppingmall;

import com.tj.shoppingmall.user.join.JoinDTO;
import com.tj.shoppingmall.user.join.JoinService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JoinTest {

    @Autowired
    JoinService joinService;



    @Test
    public void insertTest(){
        JoinDTO joinDTO = JoinDTO.builder()
                .mid("testID1")
                .mname("testName1")
                .mpass("123")
                .memail("TestID@naver.com")
                .mtel("01054215555")
                .maddr("서울시 성북구 솔샘로")
                .build();
        System.out.println("joinDTO = " + joinDTO.toString());
        int a = joinService.updateMember(joinDTO);
        System.out.println("a = " + a);
    }

    @Test
    public void getAllTest(){

        List<JoinDTO> list = joinService.getAll();
        System.out.println(list.get(0).toString());
    }

}
