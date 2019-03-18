package com.service;

import com.pojo.User;

public interface UserService {
        int addUser(User user);

        int deleteUserById(int id);

        int updateUser(User user);

        User queryByName(String userName);
}

