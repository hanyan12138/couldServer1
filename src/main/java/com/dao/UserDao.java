package com.dao;

import com.pojo.User;

public interface UserDao {
    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User queryByName(String userName);
}
