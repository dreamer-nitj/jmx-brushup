package com.learn.jmx.impl;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Main {
	public static void main(String[] args) throws Exception {
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		ObjectName objectName = new ObjectName("com.learn.jmx.impl:type=Hello");
		
		Hello mbean = new Hello();
		mBeanServer.registerMBean(mbean, objectName);
		
		ObjectName mxbeanName = new ObjectName("com.learn.jmx.impl:type=QueueSampler");
		
		Queue<String> queue = new ArrayBlockingQueue<String>(10);
		queue.add("request-1");
		queue.add("request-2");
		queue.add("request-3");
		QueueSampler mxBean = new QueueSampler(queue);
		mBeanServer.registerMBean(mxBean, mxbeanName);
		
		System.out.println("Waiting forever");
		Thread.sleep(Long.MAX_VALUE);
	}
}