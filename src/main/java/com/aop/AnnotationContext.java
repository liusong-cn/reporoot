package com.aop;

import com.learning.test.charpter20.DBTable;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
@Component
public class AnnotationContext implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        System.out.println("______________________________________________");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("是否进入方法");
        Map<String,Object> beans = context.getBeansWithAnnotation(DBTable.class);
        Set<Map.Entry<String,Object>> entrySet = beans.entrySet();
        for (Map.Entry<String,Object> entry  : entrySet) {
            String beanId = entry.getKey();
            Class<?> type = entry.getValue().getClass();
            System.out.println(beanId);
            System.out.println(type);
        }
    }

    public static ApplicationContext getContext(){
        return context;
    }
}
