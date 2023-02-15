package cn.happyOnion801.study.ssm.utils;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建异常处理器，当一个controller方法出现异常时，将调用调异常处理器，异常处理器通常是跳转到一个友好的错误提示页面
 */
public class MyExpResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        req.setAttribute("msg", "Happen an Error!");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
