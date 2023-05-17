package com.kbstar.cart;


import com.kbstar.service.CartService;
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
     * 일시 : 5.15
     * 내용 : 판매상품 신규 등록 완료
     * 테스트 정보 : product_id 1003 항목 insert / 수량추가(update)
     *
     * **/

    @Autowired
    CartService cartService;
    @Test
    void contextLoads(){
        try {
            cartService.remove(1001);
            log.info("=========== Aespa 판매 상품 중 특정 1건 삭제 완료============");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
