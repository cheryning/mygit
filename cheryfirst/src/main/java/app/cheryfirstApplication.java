package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.chery.mapper")
public class cheryfirstApplication {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(cheryfirstApplication.class,args);
	}

}
