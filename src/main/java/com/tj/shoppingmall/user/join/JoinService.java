package com.tj.shoppingmall.user.join;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface JoinService {
    public int insertMember(JoinRequestDTO joinRequestDTO);
    public List<JoinDTO> getAll();
    public JoinDTO selectById(String mid);
    public JoinDTO selectByEmail(String memail);

    default JoinDTO requestDtoToDTo(JoinRequestDTO joinRequestDTO){

        JoinDTO joinDTO = JoinDTO.builder()
                .mid(joinRequestDTO.getMid())
                .mpass(SHA256(joinRequestDTO.getMpass()))
                .mname(joinRequestDTO.getMname())
                .memail(joinRequestDTO.getMemail0()+"@"+joinRequestDTO.getMemail1())
                .mtel(joinRequestDTO.getMtel0()+joinRequestDTO.getMtel1()+joinRequestDTO.getMtel2())
                .maddrnum(joinRequestDTO.getMaddrnum())
                .maddr(joinRequestDTO.getMaddr())
                .maddrdetail(joinRequestDTO.getMaddrdetail())
                .indate(LocalDateTime.now())
                .build();

        return joinDTO;
    }
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
