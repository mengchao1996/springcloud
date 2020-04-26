package com.mengchao.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * @ClassName RibbonConfig
 * @Author MengChao
 * @Date 2020/4/21  15:44
 **/
@Configuration
public class RibbonConfig {

    /*
     * @Name:restTemplate发送请求 注解可以负载均衡
     * @Author: MengChao
     * @Date:
     **/
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

    /*
     * @Name:指定负载均衡算法
     * @Author: MengChao
     * @Date:
     **/
    @Bean
    public IRule iRule(){
        //随机算法
        //return new RandomRule();
        return new RoundRobinRule();
    }

}
