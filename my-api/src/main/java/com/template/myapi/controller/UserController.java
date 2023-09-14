package com.template.myapi.controller;

import com.template.myapi.controller.req.UserCreateReq;
import com.template.myapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 회원 가입
     */
    @PostMapping
    public int create(@RequestBody UserCreateReq req) {
        if (req.getEmail() == null) throw new RuntimeException("이메일은 필수입니다.");
        if (req.getName() == null) throw new RuntimeException("이름은 필수입니다.");
        if (req.getAge() == null) throw new RuntimeException("나이는 필수입니다.");

        return userService.create(req);
    }
}
