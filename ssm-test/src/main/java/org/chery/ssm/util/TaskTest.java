package org.chery.ssm.util;

import java.util.Date;

import org.chery.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  //把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
public class TaskTest {
@Autowired
private UserService userService;
	
	@Scheduled(cron="0/5 * * * * ?")
	 public void test() {
		int num =userService.countnum();
		Date date = new Date();
		/*
		System.out.println("当前会员总数为"+num);
		System.out.println("定时任务开启，执行时间为"+date);
		*/
	}
}
