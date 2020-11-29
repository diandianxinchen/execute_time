package com.example.demo;

import com.example.demo.entity.ExecuteTime;

import java.util.LinkedList;

/**
 * @author ALazyBoy
 * Date: 2020/11/29
 */
public class TimeThreadLocalHolder {
    private static ThreadLocal<ExecuteTime> timeModelThreadLocal = new ExecuteTimeThreadLocal();

    public static ExecuteTime getThreadLocal() {
        return timeModelThreadLocal.get();
    }

    public static void setTotal(Long total) {
        ExecuteTime executeTime = timeModelThreadLocal.get();
        executeTime.setTotalTime(total);
    }

    public static void addIO(String name, Long time) {
        ExecuteTime executeTime = timeModelThreadLocal.get();
        NameAndTime nameAndTime = new NameAndTime(name, time);
        executeTime.getIoList().add(nameAndTime);
    }

    public static void setName(String name) {
        ExecuteTime executeTime = timeModelThreadLocal.get();
        executeTime.setName(name);
    }

    public static void clear() {
        ExecuteTime executeTime = timeModelThreadLocal.get();
        executeTime.setIoTime(0);
        executeTime.getIoList().clear();
    }
}
