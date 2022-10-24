package com.tj.shoppingmall.user.join;

import java.util.List;

public interface JoinService {
    public int updateMember(JoinRequestDTO joinRequestDTO);
    public List<JoinDTO> getAll();
    public JoinDTO selectById(String mid);
    public JoinDTO selectByEmail(String memail);

    default JoinDTO requestDtoToDTo(JoinRequestDTO joinRequestDTO){

        JoinDTO joinDTO = JoinDTO.builder()
                .mid(joinRequestDTO.getMid())
                .mpass(joinRequestDTO.getMpass())
                .mname(joinRequestDTO.getMname())
                .memail(joinRequestDTO.getMemail0()+"@"+joinRequestDTO.getMemail1())
                .mtel(joinRequestDTO.getMtel0()+joinRequestDTO.getMtel1()+joinRequestDTO.getMtel2())
                .maddrnum(joinRequestDTO.getMaddrnum())
                .maddr(joinRequestDTO.getMaddr())
                .maddrdetail(joinRequestDTO.getMaddrdetail())
                .build();

        return joinDTO;
    }

}
