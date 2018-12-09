package org.chery.ssm.dao;

import java.util.HashMap;
import java.util.List;

import org.chery.ssm.modle.User;
import org.springframework.stereotype.Repository;

@Repository(value="userdao")
public interface UserDao {

	public  User selectById(Integer id);

	public User getUserByName(String username);

	public void insertUser(User user);

	public List<User> querylist(HashMap<String,Object> map);

	public int countnum();

	public void addUser(User user);
}
