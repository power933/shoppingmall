package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.ItemDTO;
import com.tj.shoppingmall.user.domain.OrderDTO;
import com.tj.shoppingmall.user.domain.OrderPayRequestDTO;
import com.tj.shoppingmall.user.mapper.CartMapper;
import com.tj.shoppingmall.user.mapper.ItemMapper;
import com.tj.shoppingmall.user.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    ItemMapper itemMapper;

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<ItemDTO> getItemByPcode(String pcode[]){ //pcode배열로 받아 재정립
        List<String> list = new ArrayList<String>(Arrays.asList(pcode));
        List<ItemDTO> result = new ArrayList<>();
        list.stream().forEach(i->{
            result.add(itemMapper.selectByCode(i));
        });
        return result;
    }

    @Override
    public boolean countStock(String pcode[],Integer count[]){ //주문시 재고 유무 확인
        List<String> list = new ArrayList<String>(Arrays.asList(pcode));
        List<Integer> countList = new ArrayList<Integer>(Arrays.asList(count));
        Boolean result = true;
        int i = 0;
        for(String code : list){
            int a = Integer.parseInt(itemMapper.getStock(code).getPstock()) - countList.get(i);
            result = a>=0 ? result : false;
        }
        return result;
    }

    @Override
    @Transactional
    public boolean insertOrder(OrderPayRequestDTO orderPayRequestDTO, Integer[] cartId, Integer mpoint) { //유효성 확인 후 주문
        List<OrderDTO> list = dtoToEntity(orderPayRequestDTO);
        Boolean result = true;
        if(cartId!=null){   //구매물품 장바구니 삭제
            for(int i=0; i<cartId.length;i++){
                cartMapper.deleteCart(cartId[i]);
            }
        }
        for(OrderDTO orderDTO : list){
            result = orderMapper.intsertOrder(orderDTO)>0? result:false; //상품 결제 리스트에 추가
            result = orderMapper.updateStock(orderDTO.getProduct_count(),orderDTO.getPcode())>0? result:false;  //재고 수량 변경
        }
        result = orderMapper.updateMemberPoint(mpoint)>0 ? result:false;  //포인트 추가
        return result;
    }


}
