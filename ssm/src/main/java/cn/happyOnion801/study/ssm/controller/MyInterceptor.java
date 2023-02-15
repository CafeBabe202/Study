package cn.happyOnion801.study.ssm.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建一个拦截器，之所以将它放在这个包是因为我认为他的本质是一个 controller
 * 当请求你想要拦截额的路径时，执行相应的拦截方法。
 */
public class MyInterceptor implements HandlerInterceptor {
    /*
        在执执行要被拦截的路径方法之前，将执行这个方法，如果返回false将不在进行后续的controller方法，而是直接返回
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        req.getRequestDispatcher("index.jsp").forward(req, res);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //在请求中执行这个方法
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //在请求结束后执行这个方法
    }
    /*
        我想你肯定不明白后边这两个是啥东西，没事，去Hello的 controller
     */
}
