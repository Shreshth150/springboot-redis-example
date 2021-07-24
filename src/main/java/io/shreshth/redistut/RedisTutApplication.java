package io.shreshth.redistut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisTutApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisTutApplication.class, args);
    }

}
