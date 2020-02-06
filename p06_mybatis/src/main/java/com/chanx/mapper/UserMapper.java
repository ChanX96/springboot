package com.chanx.mapper;

import com.chanx.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Mapper：注解表示这是一个Mybatis的Mapper类
 */
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);

    int deleterUser(Integer id);
}
