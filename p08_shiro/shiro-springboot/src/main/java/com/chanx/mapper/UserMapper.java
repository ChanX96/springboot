package com.chanx.mapper;

import com.chanx.pojo.AuthUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    AuthUser queryUserByName(String name);
}
