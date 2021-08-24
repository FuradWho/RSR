package com.rsr.furad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author 13375
 */
@SpringBootApplication
@MapperScan("com/rsr/furad/mapper")
public class RsrApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsrApplication.class, args);
    }



}
