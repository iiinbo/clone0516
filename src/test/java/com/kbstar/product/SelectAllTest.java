package com.kbstar.product;


import com.kbstar.dto.Product;
import com.kbstar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class SelectAllTest {
    /**
     * 테스트 결과 : 성공!
     * 테스트 실시자 : 정인보
     * 일시 : 5.12
     * 내용 : product 테이블에 넣어져있는 상품 selectAll 조회
     * 테스트 정보 : 전체 상품 총 6건
     *
     * **/

    @Autowired
    ProductService service;
    @Test
    void contextLoads(){
        try {
            List<Product> result = null;
            result =  service.get();
            log.info("=========== Aespa몰에서 판매 중인 상품 전체조회 완료============");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
