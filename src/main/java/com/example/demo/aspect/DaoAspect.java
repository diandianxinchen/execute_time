package com.example.demo.aspect;

import com.example.demo.NameAndTime;
import com.example.demo.TimeThreadLocalHolder;
import com.example.demo.entity.ExecuteTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ALazyBoy
 * Date: 2020/11/29
 */
@Component
@Aspect
public class DaoAspect {

    @Pointcut(value = "execution(* com.example.demo.dao.*.*(..))")
    public void dao(){}

    @Around(value = "dao()")
    public Object daoAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        String name = signature.getName();
        long startTime = System.currentTimeMillis();
        Object res = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        ExecuteTime executeTime = TimeThreadLocalHolder.getThreadLocal();
        Long ioTime = executeTime.getIoTime();
        ioTime = ioTime + (endTime - startTime);
        executeTime.setIoTime(ioTime);
        executeTime.getIoList().add(new NameAndTime(name, (endTime - startTime)));
        return res;
    }
}
