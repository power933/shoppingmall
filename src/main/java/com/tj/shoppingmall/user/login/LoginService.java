package com.tj.shoppingmall.user.login;

import java.security.MessageDigest;

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

}
