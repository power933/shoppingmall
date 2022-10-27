package com.tj.shoppingmall.user.cart;

import com.tj.shoppingmall.user.login.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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
        String mid = "";
        List<CartProductDTO> list = null;
        if(loginDTO!=null) {
            mid = loginDTO.getMid();
        }
         list = cartService.getCartList(mid);
        model.addAttribute("list", list);
        model.addAttribute("size",list.size());
        model.addAttribute("member",cartService.getMemberList(mid));

        return "cart/ordercart";
    }
    @RequestMapping("/cartinsert")
    public RedirectView cartInsert(Model model, String pcode, String product_count, String iscart, HttpSession session){
        RedirectView redirectView = new RedirectView();
        if(session.getAttribute("user")!=null){
            LoginDTO loginDTO = (LoginDTO) session.getAttribute("user");
            String mid = loginDTO.getMid();
            int a = cartService.insertCart(mid, pcode, product_count);
            if(iscart.equals("Y")) {
                redirectView.setUrl("/cart");
                return redirectView;
            }
            else {
                redirectView.setUrl("/item?pcode="+pcode);
                return redirectView;
            }
        }
        else{
            redirectView.setUrl("/");
            return redirectView;
        }
    }
    @RequestMapping("/cartdelete")
    public RedirectView carttest(@RequestParam("cart_option_seq[]") List<Integer> cartId){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cart");

         if(cartService.deleteCart(cartId))
             redirectView.setUrl("/cart");
         else
             redirectView.setUrl("/");

        return redirectView;
    }

}
