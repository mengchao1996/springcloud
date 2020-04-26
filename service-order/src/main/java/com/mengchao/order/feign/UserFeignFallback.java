package com.mengchao.order.feign;

import com.mengchao.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/*
 * @ClassName UserFeignFallback
 * @Author MengChao
 * @Date 2020/4/22  20:14
 **/
@Component
public class UserFeignFallback implements UserFeignClient{
    @Override
    public String getUserNameById(Integer id) {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        User u = new User();
        u.setId(1);
        u.setUsername("固定值");
        return u;
    }

    @Override
    public User getUserByUser(User user) {
        User u = new User();
        u.setId(1);
        u.setUsername("固定值");
        return u;
    }
}

