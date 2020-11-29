package com.example.demo.aspect;

import com.example.demo.TimeModel;
import com.example.demo.TimeThreadLocalHolder;
import com.example.demo.dao.ExecuteTimeDao;
import com.example.demo.entity.ExecuteTime;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ALazyBoy
 * Date: 2020/11/28
 */
@Aspect
@Component
public class ControllerAspect {

    @Autowired
    private ExecuteTimeDao executeTimeDao;
    /**
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
     *          修饰符匹配            返回值匹配         类路径匹配                方法名匹配      参数匹配       异常类型匹配
     */
    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    private void controller(){}

    @Around(value = "controller()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        String name = proceedingJoinPoint.getSignature().getName();
        TimeThreadLocalHolder.setName(name);
        TimeThreadLocalHolder.setTotal(end - start);
        ExecuteTime executeTime = TimeThreadLocalHolder.getThreadLocal();
        ObjectMapper objectMapper = new ObjectMapper();
        executeTime.setIoDetail(objectMapper.writeValueAsString(executeTime.getIoList()));
        executeTimeDao.insert(executeTime);
        TimeThreadLocalHolder.clear();
        return res;
    }
}
