package cn.happyonion801.study.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException {
        System.out.println("3、把bean实例传递给bean的后置处理器 ==postProcessBeforeInitialization()==");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean,String beanName) throws BeansException {
        System.out.println("5、把bean实例传递给bean的后置处理器 ==postProcessAfterInitialization()==");
        return bean;
    }
}
