package com.kbstar.product;


import com.kbstar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class DeleteTest {
    /**
     * 테스트 결과 : 성공!
     * 테스트 실시자 : 정인보
     * 일시 : 5.12
     * 내용 : product_id 단 건 입력하여 테이블에서 삭제
     * 테스트 정보 : product_id : 1008
     *
     * **/

    @Autowired
    ProductService service;
    @Test
    void contextLoads(){
        try {
                service.remove(1008);
            log.info("=========== Aespa 판매 상품 중 특정 1건 삭제 완료============");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
