package com.vk.rico.thread;

/**
 * 没有使用恰当的同步机制<br/>
 * 没能保证主线程写入ready和number的值对读线程是可见的<br/>
 * 
 * @author liangxf
 *
 */
public class NoVisibility {

	private static boolean ready;
	private static int number;

	private static class ReadThread extends Thread {
		public void run() {
			while (!ready) {
				Thread.yield();
			}
			System.out.println("number = " + number);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ReadThread().start();
		number = 22;
		ready = true;
	}
}
