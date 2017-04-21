package com.vk.rico.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class VkThreadPool {

	public static void main(String[] args) {
		// 队列容量=Integer.MAX_VALUE
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(3);

		// 2个核心线程，线程池最大6个线程
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1L, TimeUnit.DAYS, queue, new CallerRunsPolicy());

		// 当阻塞队列已满，但线程池容量还没有达到最大值，且线程池中没有空闲的线程，这时再往线程池提交任务，则新开一个线程来执行该任务，而不是将该任务放入队列中
		// 当阻塞队列已满，但线程池容量还没有达到最大值，但线程池中有空闲的线程（空闲线程回处理队列中的一个任务，这时队列中有空闲的位置），这时再往线程池提交任务，则将该任务放入队列中
		for (int i = 0; i < 10; i++) {
			executor.execute(new Thread(new UebSendData2MqTask(), "TestThread".concat(i + "")));
			int threadSize = queue.size();
			System.out.println("线程队列大小为-->" + threadSize);
		}

		// 线程池中的线程会将阻塞队列的中的所有任务全部处理完
		executor.shutdown();

		// 线程池中正在运行的线程执行完毕（线程中不能调用sleep()，否则会抛java.lang.InterruptedException异常），阻塞队列中的任务全部被丢弃
		// executor.shutdownNow();
	}
}

class UebSendData2MqTask implements Runnable {
	@Override
	public void run() {
		// synchronized (this) {
		System.err.println(Thread.currentThread().getName());
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// }
	}
}
