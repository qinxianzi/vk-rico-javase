package com.vk.rico.thread;

public class MutableInteger {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static void main(String[] args) {
		MutableInteger mi = new MutableInteger();

		new Thread() {
			public void run() {
				mi.setValue(22);
			}
		}.start();
		mi.getValue();
	}

	public static void safe() {
		SynchronizedInteger si = new SynchronizedInteger();
		new Thread() {
			public void run() {
				si.setValue(22);
			}
		}.start();
		si.getValue();
	}
}

class SynchronizedInteger {
	private int value;

	public synchronized int getValue() {
		return value;
	}

	public synchronized void setValue(int value) {
		this.value = value;
	}
}
