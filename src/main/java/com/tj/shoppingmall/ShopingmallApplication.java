package com.tj.shoppingmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShopingmallApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {

		SpringApplication.run(ShopingmallApplication.class, args);
	}

}
