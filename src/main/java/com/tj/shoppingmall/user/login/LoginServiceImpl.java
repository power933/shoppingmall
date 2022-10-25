package com.tj.shoppingmall.user.login;

import com.tj.shoppingmall.user.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public LoginDTO selectById(String mid){

        return loginMapper.selectById(mid);
    }

    @Override
    public Boolean login(String mid,String mpass){
        Boolean result;
        result =selectById(mid)!=null &&
                loginMapper.selectById(mid).getMid().equals(mid) &&
                loginMapper.selectById(mid).getMpass().equals(SHA256(mpass)) ?
                true : false;

        return result;
    }
}
