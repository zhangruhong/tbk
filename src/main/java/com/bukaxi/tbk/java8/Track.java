package com.bukaxi.tbk.java8;

public class Track {
    //曲目
    private String name;
    
    private int length;
    
    public Track(String name, int length){
    	this.name = name;
    	this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
    
}
