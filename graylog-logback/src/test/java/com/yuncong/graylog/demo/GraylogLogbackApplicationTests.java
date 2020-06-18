package com.yuncong.graylog.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class GraylogLogbackApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void saveLog() {
        log.info("你好");
    }



}
