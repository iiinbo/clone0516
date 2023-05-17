package com.kbstar.user;

import com.kbstar.dto.User;
import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;

@Slf4j
@SpringBootTest
public class UpdateTest {
    @Autowired
    UserService service;
    @Test
    void contextLoads() {
        try {
            User obj = new User("user01", "jinleerename","f", "pwd01",
                    "01033769412", "seoul, seoundong, alphaco 101","1994-12-28");
            service.modify(obj);

            service.get("user01");
        } catch (Exception e) {
            log.info("오류");
        }

    }
}
