package org.chery.ssm.service;

import java.util.HashMap;
import java.util.List;

import org.chery.ssm.modle.User;
import org.springframework.stereotype.Service;


public interface UserService {

	public User selectById(int id);

	public User getUserByName(String username);

	public void insertUser(User user);

	public List<User> querylist(HashMap<String,Object> map);

	public int countnum();

	public void addUser(User user);
}
