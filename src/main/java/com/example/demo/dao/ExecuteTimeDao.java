package com.example.demo.dao;

import com.example.demo.entity.ExecuteTime;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ALazyBoy
 * Date: 2020/11/29
 */
@Mapper
@Repository
public interface ExecuteTimeDao {
    void insert(ExecuteTime executeTime);
}
