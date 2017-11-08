package com.bukaxi.tbk.annota;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectProcessor {
	
	public void parseMethod(final Class<?> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		final Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
		final Method[] methods = obj.getClass().getDeclaredMethods();
		for(Method method : methods){
			final Reflect my = method.getAnnotation(Reflect.class);
			if(null != my){
				method.invoke(obj, my.name());
			}
		}
	}

}
