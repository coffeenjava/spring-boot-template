package com.template.myapi.service;

import com.template.myapi.controller.req.UserCreateReq;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Service
public class UserService {

    private static Pattern pattern = Pattern.compile("^010-\\d{3,4}-\\d{4}$");

    public int create(UserCreateReq req) {
        if (req.getAge() <= 10) {
            throw new RuntimeException("10세 이하는 가입이 불가합니다.");
        }

        if (req.getAge() >= 18 && req.getNationalId() == null) {
            throw new RuntimeException("18세 이상은 주민등록번호가 필요합니다.");
        }

        if (StringUtils.hasText(req.getPhone()) && pattern.matcher(req.getPhone()).matches()) {
            throw new RuntimeException("휴대폰 번호 형식이 올바르지 않습니다.");
        }

        // user 생성 관련 비즈니스 로직

        // return pk
        return 312;
    }
}
