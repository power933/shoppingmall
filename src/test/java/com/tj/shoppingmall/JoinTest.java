package com.tj.shoppingmall;

import com.tj.shoppingmall.user.join.JoinDTO;
import com.tj.shoppingmall.user.join.JoinRequestDTO;
import com.tj.shoppingmall.user.join.JoinService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JoinTest {

    @Autowired
    JoinService joinService;

    @Test
    public void insertTest(){
        JoinRequestDTO joinRequestDTO = JoinRequestDTO.builder()
                .mid("testid")
                .mname("kcs")
                .mpass("123123")
                .memail0("power1152")
                .memail1("naver.com")
                .mtel0("010")
                .mtel1("3325")
                .mtel2("4487")
                .maddrnum("4461")
                .maddr("서울시 성북구 솔샘로")
                .maddrdetail("이지명로 41-52 한샘디동 아파트 119동 1302호")
                .build();
        int a = joinService.insertMember(joinRequestDTO);
        System.out.println("a = " + a);
    }

    @Test
    public void getAllTest(){

        List<JoinDTO> list = joinService.getAll();
        System.out.println(list.get(0).toString());
    }

    @Test
    public void getOneTest(){
        Optional<JoinDTO> dto = Optional.ofNullable(joinService.selectById("zxc123"));
        System.out.println("dto = " + dto);
    }
    @Test
    public void getEmailTest(){
        Optional<JoinDTO> dto = Optional.ofNullable(joinService.selectByEmail("power933@naver.com"));
        System.out.println(dto);
    }
}
