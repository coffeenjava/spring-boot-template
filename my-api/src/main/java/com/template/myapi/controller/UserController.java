package com.template.myapi.controller;

import com.template.myapi.controller.req.UserCreateReq;
import com.template.myapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 회원 가입
     */
    @PostMapping
    public int create(@Valid @RequestBody UserCreateReq req) {
        return userService.create(req);
    }
}
