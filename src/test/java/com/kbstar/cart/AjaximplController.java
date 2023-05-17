package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ajax로 데이터처리 요청이 들어오면 그 요청을 받고 전달하는 곳! @RestController
public class AjaximplController {
    @Autowired
    CartService cartService;

    // cart 페이지로 product 추가하기.
    // 127.0.0.1/cart/addcart
    @RequestMapping("/addcart")
    public String addcart(Cart cart) throws Exception {

        try {
           cartService.register(cart);
        } catch (Exception e) {
            throw new Exception("상품을 장바구니에 담는데 실패했습니다.");
        }
        return ""; // 아무변화 없이 상품보기 페이지에 남으려면 ajax로 데이터 처리해야 함.
    }
}
