package com.tj.shoppingmall.user.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @PostMapping("/order")
    public String view(RequestOrderDTO requestOrderDTO, Model model){

        model.addAttribute("dto",requestOrderDTO);

        return "order/order";
    }
}
