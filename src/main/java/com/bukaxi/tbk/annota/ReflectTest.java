package com.bukaxi.tbk.annota;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;

public class ReflectTest {
	
	@Autowired
	private ReflectTest test;
	
	@Reflect(name = "tw2")
	public static void sayHello(final String name) {
        System.out.println("==>> Hi, " + name + " [sayHello]");
    }
	
	@Reflect()
	public static void sayHelloToSomeone(final String name) {
        System.out.println("==>> Hi, " + name + " [sayHelloToSomeone]");
    }
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
//		final ReflectProcessor process = new ReflectProcessor();
//		process.parseMethod(ReflectTest.class);
		
	}



}
