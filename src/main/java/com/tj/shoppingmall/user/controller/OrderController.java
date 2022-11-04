package com.tj.shoppingmall.user.controller;

import com.tj.shoppingmall.user.domain.ItemDTO;
import com.tj.shoppingmall.user.domain.OrderPayRequestDTO;
import com.tj.shoppingmall.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @RequestMapping("/order")
    public String view(String[] pcode, Integer[] product_ea,@RequestParam(required = false) Integer cartId[], Model model){

        List<ItemDTO> itemDTO = orderService.getItemByPcode(pcode);
        model.addAttribute("list",itemDTO);
        model.addAttribute("count",product_ea);
        model.addAttribute("cartId",cartId);

        return "order/order";
    }
    @PostMapping("/countstock")
    @ResponseBody
    public Map<String,Boolean> countstock(String[] pcode, Integer[] product_ea){    //재고여부 판단
        Boolean b = orderService.countStock(pcode,product_ea);
        Map<String,Boolean> map = new HashMap<>();
        map.put("result",b);
        return map;
    }

    @PostMapping("/paydone")    //결제완료시
    public String paydone(@ModelAttribute("list") OrderPayRequestDTO orderPayRequestDTO, Model model,
                          @RequestParam(required = false) Integer[] cartId){
        orderPayRequestDTO.setOrderdate(LocalDateTime.now());   //시간 추가
        Integer point = orderPayRequestDTO.getPriceeach()[0]/100;
        model.addAttribute("count",orderPayRequestDTO.getCount());  //물건 수량 받아 처리
        return orderService.insertOrder(orderPayRequestDTO,cartId,point)?"complet/complet":"order/order"; //성공시 완료페이지, 실패시 주문페이지로 리턴
    }
}
