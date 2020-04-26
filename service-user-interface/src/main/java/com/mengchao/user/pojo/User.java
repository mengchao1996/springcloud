package com.mengchao.user.pojo;

import lombok.Data;

import java.io.Serializable;

/*
 * @ClassName User
 * @Author MengChao
 * @Date 2020/4/21  14:49
 **/
@Data
public class User implements Serializable {

    private Integer id;
    private String username;

}
