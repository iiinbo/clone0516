package com.kbstar.service;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Product;
import com.kbstar.frame.AespaService;
import com.kbstar.mapper.CartMapper;
import com.kbstar.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartService implements AespaService<Integer, Cart> {

    /**
     * 등록 & 가입 진행
     * argument : object
     *
     * @param cart
     **/

    @Autowired
    CartMapper cartMapper;

    @Override
    public void register(Cart cart) throws Exception {
        cartMapper.insert(cart);
    }

    @Override
    public void remove(Integer product_id) throws Exception {
        cartMapper.delete(product_id); // 상품번호별로 삭제하기.
    }

    @Override
    public void modify(Cart cart) throws Exception {
        cartMapper.update(cart);
    }

    @Override
    public Cart get(Integer product_id) throws Exception {
        return cartMapper.select(product_id);
    }

    @Override
    public List<Cart> get() throws Exception {
        return cartMapper.selectall();
    }
    // 로그인한 회원(loginuser)의 장바구니 조회하기
    public List<Cart> getmycart(String user_id) throws Exception {
        return cartMapper.getmycart(user_id);
        // 전체회원의 장바구니 조회 아니고, loginuser의 장바구니만 조회하기.( = uid)
    }
}
