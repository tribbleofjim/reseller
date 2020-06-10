package com.web.reseller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/web/reseller/controller/dao")
public class ResellerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResellerApplication.class, args);
    }
}
