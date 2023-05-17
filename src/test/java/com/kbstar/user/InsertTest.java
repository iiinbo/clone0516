package com.kbstar.user;

import com.kbstar.dto.User;
import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@SpringBootTest
public class InsertTest {
    @Autowired
    UserService service;
    @Test
    void contextLoads() throws ParseException {

        User obj = new User("tiffanylover", "jin","f", "pwd01",
                "01033769412", "seoul, seoundong, alphaco 101","1994-12-28");
        try {
            service.register(obj);
            log.info("등록 정상");
        } catch (Exception e) {
            if(e instanceof DuplicateKeyException){
                log.info("ID가 중복 되었습니다.-------------------------------");
            }else{
                log.info("시스템 장애입니다.----------------------------------");
            }
        }
    }
}
