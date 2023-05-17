package com.kbstar.product;


import com.kbstar.dto.Product;
import com.kbstar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
@Slf4j
public class InsertTest {
    /**
     * 테스트 결과 : 성공!
     * 테스트 실시자 : 정인보
     * 일시 : 5.12
     * 내용 : 판매상품 신규 등록 완료
     * 테스트 정보 : product_id 1006, 1007, 1008
     *
     * **/

    @Autowired
    ProductService service;
    @Test
    void contextLoads(){
        Product product1 = new Product(0, "클러스터이어링", 1050000, null,"tiffany_ring3.jpg", 102);
        Product product2 = new Product(0, "진주드롭이어링222", 890000, null,"tiffany_earring3.jpg", 101, 1);
        try {
                service.register(product2);
            log.info("=========== Aespa 판매 상품 신규 등록 완료============");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
