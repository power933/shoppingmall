package com.tj.shoppingmall.user.join;

import java.util.List;

public interface JoinService {
    public int updateMember(JoinDTO joinDTO);
    public List<JoinDTO> getAll();
}
