package com.tj.shoppingmall.user.cart;

import com.tj.shoppingmall.user.login.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class CartController {

    @Autowired
    CartService cartService;
    @RequestMapping("/cart")
    public String item(Model model, HttpSession session){

        LoginDTO loginDTO = (LoginDTO) session.getAttribute("user");
        String mid = loginDTO.getMid();
        List<CartProductDTO> list = cartService.getCartList(mid);

        model.addAttribute("list",list);
        return "cart/ordercart";
    }
    @RequestMapping("/cartinsert")
    public String cartInsert(Model model, String pcode, String product_count, String iscart, HttpSession session){
        if(session.getAttribute("user")!=null){
            LoginDTO loginDTO = (LoginDTO) session.getAttribute("user");
            String mid = loginDTO.getMid();
            int a = cartService.insertCart(mid, pcode, product_count);
            if(iscart.equals("Y")) {
                return "cart/ordercart";
            }
            else {
                return "redirect:item?pcode="+pcode;
            }
        }
        else{
            return "index/index";
        }

    }

}
