package com.mengchao.user.service;

import com.mengchao.user.pojo.User;
import org.springframework.stereotype.Service;

/*
 * @ClassName UserServiceImpl
 * @Author MengChao
 * @Date 2020/4/21  14:43
 **/
@Service
public class UserServiceImpl implements UserService {
    /*
     * @Name:根据id查询用户名称
     * @Author: MengChao
     * @Date:
     **/
    public String getUserNameById(Integer id) {
        User user = getUserById(id);
        return user.getUsername();
    }

    /*
     * @Name:根据id查询User
     * @Author: MengChao
     * @Date:
     **/
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("userName:"+id);
        return user;
    }
}
