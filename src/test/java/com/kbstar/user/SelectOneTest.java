package com.kbstar.user;

import com.kbstar.dto.User;
import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SelectOneTest {
    @Autowired
    UserService service;
    @Test
    void contextLoads() {
        User user = null;
        try {
            user = service.get("user01");
            log.info("-----------------------------------");
            log.info(user.toString());
            log.info("-----------------------------------");

        } catch (Exception e) {
            log.info("오류");
        }
    }
}
