package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ALazyBoy
 * Date: 2020/11/28
 */
@Repository
@Mapper
public interface UserDao {
    User selectUserInfoById(String id);
    void insertUser(User user);
}
