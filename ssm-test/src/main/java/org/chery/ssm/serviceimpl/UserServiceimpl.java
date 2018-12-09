package org.chery.ssm.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.chery.ssm.dao.UserDao;
import org.chery.ssm.modle.User;
import org.chery.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userservice")
public class UserServiceimpl implements UserService {

	@Resource
	private UserDao userdao;
	@Override
	public User selectById(int id) {
		
        User user = userdao.selectById(id);
		
		return user;
	}
	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		 User user = userdao.getUserByName(username);
		return user;
	}
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userdao.insertUser(user);
		
	}
	@Override
	public List<User> querylist(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		 list = userdao.querylist(map);
		return list;
	}
	@Override
	public int countnum() {
		// TODO Auto-generated method stub
		return userdao.countnum();
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		 userdao.addUser(user);
		
	}

}
