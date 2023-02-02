package com.template.myapi.service;

import com.template.myapi.controller.req.UserCreateReq;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public int create(UserCreateReq req) {
        if (req.getAge() != null) {
            throw new RuntimeException("나이는 필수입니다.");
        }

        if (req.getAge() <= 10) {
            throw new RuntimeException("10세 이하는 가입이 불가합니다.");
        }

        if (req.getAge() >= 18 && req.getNationalId() == null) {
            throw new RuntimeException("18세 이상은 주민등록번호가 필요합니다.");
        }

        // user 생성 비즈니스 로직
        // db create
        // 생성된 pk 가 결과

        return 312;
    }
}
