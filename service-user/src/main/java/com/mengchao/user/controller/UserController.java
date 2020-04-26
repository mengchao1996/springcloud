package com.mengchao.user.controller;

import com.mengchao.user.pojo.User;
import com.mengchao.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @ClassName UserController
 * @Author MengChao
 * @Date 2020/4/21  14:44
 **/
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserNameById")
    public String getUserNameById(@RequestParam("id") Integer id){
        return userService.getUserNameById(id);
    }

    @RequestMapping("/getUserById")
    public User getUserById(@RequestParam("id") Integer id){
        log.info("userId:{}",id);
        return userService.getUserById(id);
    }

    @RequestMapping("/getUserByUser")
    public String getUserByUser(@RequestBody User user){
        log.info("userId:{}",user.getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.getUserNameById(user.getId());
    }


}
