package cn.chery.service;

import cn.chery.model.User;
import cn.chery.model.User_t;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    void insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
