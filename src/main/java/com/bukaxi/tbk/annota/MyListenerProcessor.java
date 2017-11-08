package com.bukaxi.tbk.annota;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

public class MyListenerProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
		if(methods != null){
			for(Method mt : methods){
				Reflect myListener = AnnotationUtils.findAnnotation(mt, Reflect.class);
				System.out.println(myListener.value());
			}
		}
		return null;
	}

}
