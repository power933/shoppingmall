package com.tj.shoppingmall.user.order;

import com.tj.shoppingmall.user.item.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @RequestMapping("/order")
    public String view(String[] pcode, String product_ea, Model model){
        List<ItemDTO> itemDTO = orderService.getItemByPcode(pcode);
        model.addAttribute("list",itemDTO);
        model.addAttribute("count",product_ea);
        return "order/order";
    }
}
