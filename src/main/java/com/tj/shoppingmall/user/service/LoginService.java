package com.tj.shoppingmall.user.service;

import com.tj.shoppingmall.user.domain.LoginDTO;

import java.security.MessageDigest;
import java.util.Map;

public interface LoginService {
    Boolean login(String mid,String mpass);
    LoginDTO selectById(String mid);
    default String SHA256(String pass){ //pw SHA256 단방향 암호화
        StringBuffer sbuf = new StringBuffer();
        try{
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            mDigest.update(pass.getBytes());

            byte[] msgStr = mDigest.digest() ;

            for(int i=0; i < msgStr.length; i++){
                byte tmpStrByte = msgStr[i];
                String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);
                sbuf.append(tmpEncTxt) ;
            }
        }catch (Exception e){

        }
        return sbuf.toString();
    }

    public String getReturnAccessToken(String code);
    public Map<String,Object> getUserInfo(String access_token);

}
