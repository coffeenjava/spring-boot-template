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

    @PostMapping
    public int create(@RequestBody UserCreateReq req) {
        if (req.getEmail() == null) throw new RuntimeException("email 은 필수입니다.");
        return userService.create(req);
    }
}
