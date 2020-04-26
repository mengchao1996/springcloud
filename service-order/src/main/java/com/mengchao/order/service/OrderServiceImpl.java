package com.mengchao.order.service;

import com.mengchao.order.pojo.Order;
import org.springframework.stereotype.Service;

/*
 * @ClassName OrderServiceImpl
 * @Author MengChao
 * @Date 2020/4/21  15:12
 **/
@Service
public class OrderServiceImpl implements OrderService{


    /*
     * @Name:根据id,查询order
     * @Author: MengChao
     * @Date:
     **/
    public Order getOrderById(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setUserId(1);
        order.setOederno(System.currentTimeMillis()+"");
        return order;
}
}
