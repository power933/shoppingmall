package com.tj.shoppingmall.user.join;

import com.tj.shoppingmall.user.mapper.JoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinServiceImpl implements JoinService{
    @Autowired
    JoinMapper joinMapper;
    public int updateMember(JoinDTO joinDTO){
        return joinMapper.memberUpdate(joinDTO);
    }
    public List<JoinDTO> getAll(){
        return joinMapper.getAll();
    }
}
