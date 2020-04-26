package com.mengchao.order.service;

import com.mengchao.order.pojo.Order;

/*
 * @ClassName OrderService
 * @Author MengChao
 * @Date 2020/4/21  15:12
 **/
public interface OrderService {
    Order getOrderById(Integer id);
}
