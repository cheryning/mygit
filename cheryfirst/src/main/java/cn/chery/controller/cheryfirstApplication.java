package cn.chery.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("cn.chery.mapper")
@ComponentScan(basePackages = "cn.chery.*")
public class cheryfirstApplication {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(cheryfirstApplication.class,args);
	}

}
