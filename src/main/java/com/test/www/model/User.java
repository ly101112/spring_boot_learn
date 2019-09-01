package com.test.www.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long creatTime;
    private Long modifiedTime;
    private String avatar;

    public User setTmpUser(){
        this.setId(1);
        this.setAccountId("123");
        this.setName("y");
        this.setToken("123sadasd");
        return this;
    }
}
