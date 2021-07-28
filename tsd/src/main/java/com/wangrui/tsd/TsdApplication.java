package com.wangrui.tsd;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement // 启用事务
@SpringBootApplication
@EnableCaching // 启用缓存
public class TsdApplication {

	public static void main(String[] args) {
		SpringApplication.run(TsdApplication.class, args);
	}

}
