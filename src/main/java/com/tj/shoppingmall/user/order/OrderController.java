package com.tj.shoppingmall.user.order;

import com.tj.shoppingmall.user.item.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

        model.addAttribute("cartId",cartId!=null?cartId:"none");
        return "order/order";
    }
    @PostMapping("/countstock")
    @ResponseBody
    public Map<String,Boolean> countstock(String[] pcode, Integer[] product_ea){
        Boolean b = orderService.countStock(pcode,product_ea);
        Map<String,Boolean> map = new HashMap<>();
        map.put("result",b);
        return map;
    }

    @PostMapping("/paydone")
    public String paydone(@ModelAttribute("list") OrderPayRequestDTO orderPayRequestDTO, Model model,@RequestParam(required = false) Integer[] cartId){
        orderPayRequestDTO.setOrderdate(LocalDateTime.now());
        model.addAttribute("count",orderPayRequestDTO.getCount());
        return orderService.insertOrder(orderPayRequestDTO,cartId)?"complet/complet":"order/order";
    }
}
