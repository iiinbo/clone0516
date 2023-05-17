package com.kbstar.cart;


import com.kbstar.dto.Cart;
import com.kbstar.dto.Product;
import com.kbstar.service.CartService;
import com.kbstar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class SelectMyCartTest {
    /**
     * 테스트 결과 : 성공!
     * 테스트 실시자 : 정인보
     * 일시 : 5.15
     * 내용 : user_id(user01) 고객이 담은 cart 안에 product 모두 조회
     * 테스트 정보 : 전체 상품 총 1건
     *
     * **/

    @Autowired
    CartService service;
    @Test
    void contextLoads(){
        try {
           service.getmycart("user01"); // uid 란? 로그인한 고객
            log.info("=========== user01 고객이 cart에 담은 상품 전체조회 완료============");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
