package com.example.demo;

import com.example.demo.entity.ExecuteTime;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ALazyBoy
 * Date: 2020/11/29
 */
public class ExecuteTimeThreadLocal extends ThreadLocal<ExecuteTime> {

    @Override
    protected ExecuteTime initialValue() {
        ExecuteTime executeTime = new ExecuteTime();
        List<NameAndTime> ioList = new LinkedList<>();
        executeTime.setIoList(ioList);
        return executeTime;
    }
}
