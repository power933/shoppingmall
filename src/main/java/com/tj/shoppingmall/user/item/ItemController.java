package com.tj.shoppingmall.user.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ItemController {

    @Autowired
    ItemService itemService;
    @RequestMapping("/item")
    public String item(Model model,
                       @RequestParam(value="pcode", defaultValue = "115357") String pcode){
        ItemDTO itemDTO = itemService.selectByCode(pcode);

        model.addAttribute("dto",itemDTO);

        return "item/item";
    }
}
