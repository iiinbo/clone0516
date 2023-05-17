package com.kbstar.product;


import com.kbstar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class SelectErgTest {
    /**
     * 테스트 결과 : 성공!
     * 테스트 실시자 : 정인보
     * 일시 : 5.13
     * 내용 : 이어링만 모아보기
     * 테스트 정보 : CATEGORY_ID : 101
     *
     * **/

    @Autowired
    ProductService service;
    @Test
    void contextLoads(){
        try {
                service.selecterg();
            log.info("=========== Aespa 판매 상품 중 이어링 제품 전체 조회 완료============");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
