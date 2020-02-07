package com.chanx.service.impl;

import com.chanx.mapper.UserMapper;
import com.chanx.pojo.AuthUser;
import com.chanx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AuthUser queryUserByName(String name) {
        AuthUser authUser = userMapper.queryUserByName(name);
        return authUser;
    }
}
