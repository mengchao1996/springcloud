package com.mengchao.order.pojo;

import lombok.Data;

/*
 * @ClassName Order
 * @Author MengChao
 * @Date 2020/4/21  14:57
 **/
@Data
public class Order {
    private Integer id;
    private String oederno;
    private Integer userId;
    private String username;
}
