package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

/**
 * 假设现在存在一个query 接口
 * @author ALazyBoy
 * Date: 2020/11/28
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/{userId}")
    public User getUserInfo(@PathVariable String userId) {
        return userDao.selectUserInfoById(userId);
    }

    @PostMapping()
    public void addUser(@RequestBody @Valid User user) {
        userDao.insertUser(user);
    }

    @PostMapping("test")
    public User test(){
        // 做一次insert,一次select
        int name = new Random().nextInt(100);
        User user = new User();
        user.setUsername("name" + name);
        user.setRealName("realName" + name);
        user.setPassword("password" + name);
        userDao.insertUser(user);
        return userDao.selectUserInfoById(String.valueOf(name));
    }

}
