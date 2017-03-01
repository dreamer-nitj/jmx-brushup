package com.learn.jmx.impl;

public interface QueueSamplerMXBean {
	public QueueSample getQueueSample();
	
	public void clearQueue();
}
