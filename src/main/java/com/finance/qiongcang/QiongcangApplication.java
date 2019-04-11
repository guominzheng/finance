package com.finance.qiongcang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@ServletComponentScan
@ComponentScan(basePackages = {"com.finance.qiongcang.*"})
public class QiongcangApplication {

	public static void main(String[] args) {
		SpringApplication.run(QiongcangApplication.class, args);
	}

}
