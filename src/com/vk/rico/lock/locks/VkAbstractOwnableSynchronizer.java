package com.vk.rico.lock.locks;

/**
 * A synchronizer that may be exclusively owned by a thread. This class provides
 * a basis for creating locks and related synchronizers that may entail a notion
 * of ownership. The {@code AbstractOwnableSynchronizer} class itself does not
 * manage or use this information. However, subclasses and tools may use
 * appropriately maintained values to help control and monitor access and
 * provide diagnostics.
 *
 * @since 1.6
 * @author Doug Lea
 */
public abstract class VkAbstractOwnableSynchronizer implements java.io.Serializable {

	/** Use serial ID even though all fields transient. */
	private static final long serialVersionUID = 3737899427754241961L;

	/**
	 * Empty constructor for use by subclasses.
	 */
	protected VkAbstractOwnableSynchronizer() {
	}

	/**
	 * The current owner of exclusive mode synchronization.
	 */
	private transient Thread exclusiveOwnerThread;

	/**
	 * 设置当前拥有独占访问权的线程（即锁的占有者）， null参数表示没有线程拥有访问（即锁没有被任何线程占有）。此方法不另外施加任何同步或
	 * volatile字段访问。
	 */
	protected final void setExclusiveOwnerThread(Thread thread) {
		exclusiveOwnerThread = thread;
	}

	/**
	 * Returns the thread last set by {@code setExclusiveOwnerThread}, or
	 * {@code null} if never set. This method does not otherwise impose any
	 * synchronization or {@code volatile} field accesses.
	 * 
	 * @return the owner thread
	 */
	protected final Thread getExclusiveOwnerThread() {
		return exclusiveOwnerThread;
	}
}
