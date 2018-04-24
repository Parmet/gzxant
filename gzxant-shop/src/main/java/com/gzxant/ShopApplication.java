package com.gzxant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gzxant.constant.Setting;

/**
 * shop 项目启动类
 * 
 * @author xiaoyc
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(Setting.SCAN_MAPPER_PATH)
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
