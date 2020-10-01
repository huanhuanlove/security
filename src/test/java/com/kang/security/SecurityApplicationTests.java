package com.kang.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
