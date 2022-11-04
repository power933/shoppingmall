package com.tj.shoppingmall;

import com.tj.shoppingmall.user.util.MakeRanNum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilTest {

    @Autowired
    MakeRanNum makeRanNum;

    @Test
    public void ranTest(){
        System.out.println("makeRanNum.makeRandomNumber() = " + makeRanNum.makeRandomNumber());
    }
}
