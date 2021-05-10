package cn.happyonion801.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
public class UserDaoImplProxy {

    @Pointcut(value = "execution(* cn.happyonion801.study.spring.aop.UserDaoImpl.add(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void before(){
        System.out.println("before...");
    }

    @After(value = "pointCut()")
    public void after(){
        System.out.println("after...");
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("around before...");
        joinPoint.proceed();
        System.out.println("around after...");

    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }
}
