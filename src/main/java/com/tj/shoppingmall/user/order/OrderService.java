package com.tj.shoppingmall.user.order;

import com.tj.shoppingmall.user.item.ItemDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface OrderService {
    public List<ItemDTO> getItemByPcode(String pcode[]);
    public boolean countStock(String pcode[],Integer count[]);

    public boolean insertOrder(OrderPayRequestDTO orderPayRequestDTO,Integer[] cartId);

    default List<OrderDTO> dtoToEntity(OrderPayRequestDTO dto){

         List<OrderDTO> list = IntStream.range(0, dto.getPcode().length).boxed().map(i -> {
             OrderDTO orderDTO = OrderDTO.builder()
                     .ordernum(dto.getOrdernum())
                     .mid(dto.getMid()==null||dto.getMid().equals("")?"none":dto.getMid())
                     .mname(dto.getCname())
                     .mhp(dto.getChp1()==null?"none":dto.getChp1()+dto.getChp2()+dto.getChp3())
                     .mtel(dto.getCtel1()+dto.getCtel2()+dto.getCtel3())
                     .memail(dto.getRecipient_email())
                     .paytype(dto.getPayment())
                     .uname(dto.getPerson_nm())
                     .uaddr(dto.getPerson_post()+dto.getPerson_addr()+dto.getPerson_addrtc())
                     .uhp(dto.getPerson_hp()==null?"none":dto.getPerson_hp()[0]+dto.getPerson_hp()[1]+dto.getPerson_hp()[2])
                     .utel(dto.getPerson_phone()[0]+dto.getPerson_phone()[1]+dto.getPerson_phone()[2])
                     .umsg(dto.getMsg())
                     .pprice(dto.getPriceeach()[i])
                     .pcode(dto.getPcode()[i])
                     .product_count(dto.getCount()[i])
                     .orderdate(LocalDateTime.now())
                     .build();
             return orderDTO;
        }).collect(Collectors.toList());

        return list;
    }


}
