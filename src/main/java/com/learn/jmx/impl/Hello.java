package com.learn.jmx.impl;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean {
	private String name = "fake name";
	private int cacheSize = DEFAULT_CACHE_SIZE;
	private static final int DEFAULT_CACHE_SIZE = 200;
	private long sequenceNumber = 1;

	public void sayHello() {
		System.out.println("Hello World!");
	}

	public int add(int x, int y) {
		return x + y;
	}

	public String getName() {
		return this.name;
	}

	public int getCacheSize() {
		return cacheSize;
	}

	public synchronized void setCacheSize(int size) {
		int oldSize = this.cacheSize;
		this.cacheSize = size;
		System.out.println("Cache size now: " + cacheSize);
		
		Notification notification = new AttributeChangeNotification(this, sequenceNumber++,
				System.currentTimeMillis(), "Cache size changed", "cacheSize", "int", oldSize, size);
		
		sendNotification(notification);
	}
	
	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[] {
				AttributeChangeNotification.ATTRIBUTE_CHANGE
		};
		
		String name = AttributeChangeNotification.class.getName();
		String description = "An attribute of this MBean has changed";
		MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
		return new MBeanNotificationInfo[] {info};
	}
}