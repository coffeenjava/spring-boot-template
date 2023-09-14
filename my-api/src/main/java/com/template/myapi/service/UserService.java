package com.template.myapi.service;

import com.template.myapi.controller.req.UserCreateReq;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public int create(UserCreateReq req) {
        // user 생성 관련 비즈니스 로직

        // return pk
        return 312;
    }
}
