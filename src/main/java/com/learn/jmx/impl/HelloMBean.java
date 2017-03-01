package com.learn.jmx.impl;

public interface HelloMBean {
	// ------------
	// operations
	// ------------
	public void sayHello();
	
	public int add(int x, int y);
	
	// ------------
	// attributes
	// ------------
	
	// a read-only attribute called Name of type String
	public String getName();
	
	// a read-write attribute called cacheSize of type int
	public int getCacheSize();
	
	public void setCacheSize(int size);
}
