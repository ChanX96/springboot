package com.chanx.service;

import com.chanx.pojo.AuthUser;

public interface UserService {

    AuthUser queryUserByName(String name);
}
