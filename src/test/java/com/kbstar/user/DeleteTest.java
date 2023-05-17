package com.kbstar.user;


import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class DeleteTest {
    @Autowired
    UserService service;

    @Test
    void contextLoads(){
        try{
            service.remove("");
        }catch (Exception e) {
            log.info("해당 계정 삭제에 오류가 발생했습니다.");
        }
    }
}
