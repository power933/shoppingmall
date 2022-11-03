package com.tj.shoppingmall;


import com.tj.shoppingmall.user.item.ItemDTO;
import com.tj.shoppingmall.user.mapper.OrderMapper;
import com.tj.shoppingmall.user.order.OrderDTO;
import com.tj.shoppingmall.user.order.OrderPayRequestDTO;
import com.tj.shoppingmall.user.order.OrderService;
import com.tj.shoppingmall.user.order.Test1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class OrderTest {
    @Autowired
    OrderService orderService;


    @Test
    public void getPcodeTest(){
        String[] list = {"115357","111555"};
        List<ItemDTO> itemDTO = orderService.getItemByPcode(list);
        System.out.println("itemDTO = " + itemDTO);
    }

    @Test
    public void stockTest(){
        String[] pcode = {"117432","117532"};
        Integer[] count = {16,5};
        boolean b = orderService.countStock(pcode,count);
        System.out.println("b = " + b);
    }
    @Test
    public void insertTest(){
        String[] test = {"010","3412","2650"};
        String[] pc = {"111555","115357"};
        int[] ct = {1,1115};
        int[] pric = {150000,251000};
        OrderPayRequestDTO orderPayRequestDTO = OrderPayRequestDTO.builder()
                .ordernum("16515632457")
                .mid("power933")
                .cname("kcs")
                .ctel1("010")
                .ctel2("3412")
                .ctel3("2650")
                .person_nm("kcs")
                .person_post("5574")
                .person_addr("서울시 성북구 솔샘로")
                .person_addrtc("풍림아이원 119동")
                .person_phone(test)
                .recipient_email("power933@naver.com")
                .msg("안녕")
                .payment("card")
                .pcode(pc)
                .count(ct)
                .priceeach(pric)
                .build();
        Integer[] cartId= {};
        System.out.println("orderService.insertOrder(orderPayRequestDTO) = " + orderService.insertOrder(orderPayRequestDTO,cartId));

    }


    @Test
    public void convert_intstream_list_of_obj() {
        List<Test1> students = IntStream.range(0, 5)
                .mapToObj(i -> new Test1("name" + i, i + 10))
                .collect(Collectors.toList());
        System.out.println("students = " + students);
    }

}
