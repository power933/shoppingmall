package com.tj.shoppingmall.user.join;

import com.tj.shoppingmall.user.mapper.JoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinServiceImpl implements JoinService{
    @Autowired
    JoinMapper joinMapper;
    public int insertMember(JoinRequestDTO joinRequestDTO){

        JoinDTO joinDTO = requestDtoToDTo(joinRequestDTO);
        return joinMapper.memberInsert(joinDTO);
    }
    public List<JoinDTO> getAll(){

        return joinMapper.getAll();
    }

    @Override
    public JoinDTO selectById(String mid) {
        return joinMapper.findById(mid);
    }

    @Override
    public JoinDTO selectByEmail(String memail) {
        return joinMapper.findByEmail(memail);
    }
}
