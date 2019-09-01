package com.test.www.service;

import com.test.www.mapper.UserMapper;
import com.test.www.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void saveUser(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser == null){

            user.setCreatTime(System.currentTimeMillis());
            user.setModifiedTime(user.getCreatTime());
            userMapper.insertUser(user);
        } else {

            dbUser.setToken(user.getToken());
            dbUser.setName(user.getName());
            dbUser.setAvatar(user.getAvatar());
            dbUser.setModifiedTime(System.currentTimeMillis());
            userMapper.update(dbUser);
        }
    }
}
