package com.kbstar.mapper;

import com.kbstar.dto.Cart;
import com.kbstar.frame.AespaMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface CartMapper extends AespaMapper<Integer, Cart> {
    // 로그인한 회원(loginuser)의 장바구니 조회하기
    public List<Cart> getmycart(String user_id); // DB에서 user의 id 가져오기


}
