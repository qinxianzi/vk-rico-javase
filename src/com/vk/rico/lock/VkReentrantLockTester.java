package com.vk.rico.lock;

import java.util.concurrent.locks.ReentrantLock;

public class VkReentrantLockTester {

	private static final int SHARED_SHIFT = 16;
	private static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {

		// exclusiveCount();

		VkReentrantLockTester re = new VkReentrantLockTester();

		// ReentrantLock无参构造器创建的是非公平锁，即默认创建的是非公平锁
		ReentrantLock lock = new ReentrantLock();

		// 提交两个线程，这两个线程共享同一把锁
		for (int i = 0; i < 6; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						re.testNonfairSync(lock);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			if (2 == i) {
				// 设置线程的优先级
				t.setPriority(Thread.MAX_PRIORITY);
			}
			t.start();
		}
	}

	@SuppressWarnings("unused")
	private static void exclusiveCount() {
		int c = 1; // c等于0，表示锁未被占有；c大于0时，表示锁被其他线程占有（锁的重进入特点，因此c可能大于0）；
		int w = exclusiveCount(c);
		System.out.println("w = " + w);
	}

	private static int exclusiveCount(int c) {
		// 与运算符用符号"&"表示，其使用规律如下：
		// 两个操作数中位都为1，结果才为1，否则结果为0
		return c & EXCLUSIVE_MASK;
	}

	/**
	 * 测试非公平锁
	 * 
	 * @throws InterruptedException
	 */
	public void testNonfairSync(ReentrantLock lock) throws InterruptedException {
		lock.lock();
		try {
			Thread.sleep(10000);
			System.out.println(Thread.currentThread().getName() + "继续执行");
		} finally {
			lock.unlock();
		}
	}
}
