package com.mengchao.user.service;

import com.mengchao.user.pojo.User;

/*
 * @ClassName UserService
 * @Author MengChao
 * @Date 2020/4/21  14:43
 **/
public interface UserService {

    String getUserNameById(Integer id);

    User getUserById(Integer id);


}
