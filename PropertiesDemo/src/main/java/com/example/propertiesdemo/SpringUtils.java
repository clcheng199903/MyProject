package com.example.propertiesdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * BeanFactory是IOC容器本身，BeanFactoryPostProcessor获取BeanFactory，但是不能获取到environment对象
 */
@Component
public final class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static String getProperty(String key) {
        return context.getEnvironment().getProperty(key);
    }

    public static String[] getActiveProfiles() {
        return context.getEnvironment().getActiveProfiles();
    }
}
