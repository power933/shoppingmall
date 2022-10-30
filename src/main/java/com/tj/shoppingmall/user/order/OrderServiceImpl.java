package com.tj.shoppingmall.user.order;

import com.tj.shoppingmall.user.item.ItemDTO;
import com.tj.shoppingmall.user.mapper.CartMapper;
import com.tj.shoppingmall.user.mapper.ItemMapper;
import com.tj.shoppingmall.user.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public boolean insertOrder(OrderPayRequestDTO orderPayRequestDTO, Integer[] cartId) { //유효성 확인 후 주문
        List<OrderDTO> list = dtoToEntity(orderPayRequestDTO);
        Boolean result = true;
        if(cartId!=null){
            for(int i=0; i<cartId.length;i++){
                cartMapper.deleteCart(cartId[i]);
            }
        }
        for(OrderDTO orderDTO : list){
            result = orderMapper.intsertOrder(orderDTO)>0? result:false;
            result = orderMapper.updateStock(orderDTO.getProduct_count(),orderDTO.getPcode())>0? result:false;
        }
        return result;
    }


}
