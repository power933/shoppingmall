package com.tj.shoppingmall.user.controller;

import com.tj.shoppingmall.user.domain.CartProductDTO;
import com.tj.shoppingmall.user.service.CartService;
import com.tj.shoppingmall.user.domain.LoginDTO;
import com.tj.shoppingmall.user.util.MakeRanNum;
import com.tj.shoppingmall.user.util.SetAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller

public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    MakeRanNum makeRanNum;
    @RequestMapping("/cart")
    public String cartView(Model model, HttpSession session, HttpServletRequest request){

        LoginDTO loginDTO = (LoginDTO) session.getAttribute("user");
        String mid = "";
        List<CartProductDTO> list = null;
        if(loginDTO!=null) {    //로그인되었을 시
            mid = loginDTO.getMid();

        }
        else{   //비회원시
            Cookie[] cookie = request.getCookies();
                for (Cookie cookie1 : cookie) {
                    if (cookie1.getName().equals("mid")) {
                        mid = cookie1.getValue();
                    }
                }
        }
        list = cartService.getCartList(mid);
        model.addAttribute("list", list);
        model.addAttribute("size",list.size());
        model.addAttribute("member",cartService.getMemberList(mid));

        return "cart/ordercart";
    }
    @RequestMapping("/cartinsert")
    public RedirectView cartInsert (Model model, String pcode, String product_count, String iscart,
                                   HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {

        RedirectView redirectView = new RedirectView();
        LoginDTO loginDTO = (LoginDTO) session.getAttribute("user");
        Cookie[] allcookie = request.getCookies();
        String mid = "";
        if(loginDTO!=null)  //로그인 되었을시 mid 세팅
            mid =loginDTO.getMid();
        else if (allcookie==null){ // 쿠키값이 없을때 쿠키 생성
            mid = makeRanNum.makeRandomNumber();
            Cookie cookie = new Cookie("mid",mid);
        }
        else{   //기존 쿠기가 있을 시
            for(Cookie c : allcookie){
                if(c.getName().equals("mid")){
                    mid = c.getValue();
                }
            }
        }

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
