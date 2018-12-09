package org.chery.ssm.util;

import java.util.Date;

import org.chery.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  //����ͨpojoʵ������spring�����У��൱�������ļ��е�<bean id="" class=""/>
public class TaskTest {
@Autowired
private UserService userService;
	
	@Scheduled(cron="0/5 * * * * ?")
	 public void test() {
		int num =userService.countnum();
		Date date = new Date();
		/*
		System.out.println("��ǰ��Ա����Ϊ"+num);
		System.out.println("��ʱ��������ִ��ʱ��Ϊ"+date);
		*/
	}
}
