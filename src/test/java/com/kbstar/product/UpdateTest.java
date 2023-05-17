package com.kbstar.product;


import com.kbstar.dto.Product;
import com.kbstar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class UpdateTest {
    /**
     * 테스트 결과 : 성공!
     * 테스트 실시자 : 정인보
     * 일시 : 5.12
     * 내용 : 판매상품 중 정보 수정 (상품명, 상품금액)
     * 테스트 정보 : product_id 1000
     *
     * **/

    @Autowired
    ProductService service;
    @Test
    void contextLoads(){
        Product product = new Product(1000, "마더펄 서클이어링", 3260000, null,"tiffany_earring1.jpg", 101);

        try {
                service.modify(product);
            log.info("=========== Aespa 판매 상품 정보 수정 완료============");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
