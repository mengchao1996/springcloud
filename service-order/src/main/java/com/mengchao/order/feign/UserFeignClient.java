package com.mengchao.order.feign;

import com.mengchao.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @ClassName UserFeignClient
 * @Author MengChao
 * @Date 2020/4/21  22:00
 **/
@Component
@FeignClient(name="service-user",fallback = UserFeignFallback.class)
public interface UserFeignClient {

    @RequestMapping("/user/getUserNameById")
    public String getUserNameById(@RequestParam("id") Integer id);

    @RequestMapping("/user/getUserById")
    public User getUserById(@RequestParam("id") Integer id);

    @RequestMapping("/getUserByUser")
    public User getUserByUser(@RequestBody User user);

}
