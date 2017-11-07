package com.bukaxi.tbk.annota;

@NameScanner
public class NameScannerTest {
	
	@NameScanner
	private String name;
	
	@NameScanner
	private int age;
	
	@NameScanner
	public String getName() {
		return name;
	}

	@NameScanner
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--finished--");
	}

}
