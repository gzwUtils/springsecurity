package com.ddxx;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ddxx.demo.domain.AccountInfo;
import com.ddxx.demo.service.AccountInfoService;
import com.ddxx.demo.service.impl.AccountInfoServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//开启事务支持
@EnableTransactionManagement
//启动API接口调试
//@EnableSwagger2
@SpringBootApplication
//@MapperScan("com.ddxx.demo")
//@EnableConfigurationProperties({ YmlConfig.class})
public class MainApplication {


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		AccountInfo accountInfo=new AccountInfo();
		accountInfo.setName("xiao");
		accountInfo.setDisplay_name("sss");
		accountInfo.setSex(1);
		accountInfo.setId("3");
		accountInfo.setPassword("kg12312");
		accountInfo.setPosition("2");
		accountInfo.setSchool("人名大学");
		accountInfo.setCreate_time(new Date());
		AccountInfoService accountInfoService=new AccountInfoServiceImpl();
		Integer count=accountInfoService.addAccountInfo(accountInfo);
		System.out.println(count);
	}
		 
}



