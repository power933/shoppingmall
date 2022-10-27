package com.tj.shoppingmall.user.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {
    @RequestMapping("/payment")
    public String view(){

        return "payment/payment";
    }
}
