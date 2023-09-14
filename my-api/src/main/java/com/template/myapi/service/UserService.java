package com.template.myapi.service;

import com.template.myapi.controller.req.UserCreateReq;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public int create(UserCreateReq req) {
        if (req.getAge() >= 18 && req.getNationalId() == null) {
            throw new RuntimeException("18세 이상은 주민등록번호가 필요합니다.");
        }

        // user 생성 관련 비즈니스 로직

        // return pk
        return 312;
    }
}
