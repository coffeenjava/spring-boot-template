package com.template.myapi.controller.req;

import lombok.Getter;

@Getter
public class UserCreateReq {

    private String email;
    private String name;
    private String phone;
    private Integer age;
    private String nationalId;
}
