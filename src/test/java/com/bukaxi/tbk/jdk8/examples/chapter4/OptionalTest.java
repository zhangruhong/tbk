package com.bukaxi.tbk.jdk8.examples.chapter4;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {
	
	@Test
	public void test1(){
		Optional<String> a = Optional.of("a");
		System.out.println("a".equals(a.get()));
		System.out.println(a.ofNullable(null).orElse("b"));
		System.out.println(a.ofNullable(null).orElseGet(() -> "c"));
//		assertEq
	}

}
