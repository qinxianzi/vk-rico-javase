package com.vk.rico.data.structure.list;

import com.vk.rico.data.structure.list.arraylist.VkArrayList;

/**
 * 测试ArrayList
 * 
 * @author liangxf
 *
 */
public class VkArrayListTester {

	public static void main(String[] args) {
		// 初始容量为0
		VkArrayList<String> al = new VkArrayList<String>(3);
		System.out.println("初始容量是:" + al.size());

		// 增加一个元素，将扩容，扩容后数组元素个数是10
		al.add("测试内容0");
		System.out.println("第一次扩容后的容量是：" + al.size());

		for (int i = 1; i < 20; i++) {
			// 设置条件断点，条件为：i==9，即往数组中再填充9个元素，这时总共是10个元素，达到数组的长度，增加第10个元素时，将进行第二次扩容
			al.add("测试内容" + i);
		}

		// 删除第0个元素，数组后面的元素都需要往前移动一个位置，再将最后一个位置设置为null，因此这种删除效率是比较低的
		al.remove(0);

		// 删除最后一个元素，直接将最后一个元素设置为null，不需要移动元素位置，这种删除效率是比较高的
		al.remove(al.size() - 1);

		// testRemoveAll();
		testOOM();
	}

	/**
	 * 测试初始容量
	 */
	public static void testDefaultCapacity() {
		// Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = null;
		Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
		DEFAULTCAPACITY_EMPTY_ELEMENTDATA[0] = "abcd";
		System.out.println(DEFAULTCAPACITY_EMPTY_ELEMENTDATA.length);
	}

	public static void testRemoveAll() {
		VkArrayList<String> a1 = new VkArrayList<String>(4);
		a1.add("b");
		a1.add("c");
		a1.add("d");
		a1.add("e");

		VkArrayList<String> a2 = new VkArrayList<String>(3);
		a2.add("d");
		a2.add("e");

		boolean flag = a2.removeAll(a1);
		System.out.println(flag);
	}

	public static void testOOM() {
		// http://stackoverflow.com/questions/31382531/why-i-cant-create-an-array-with-large-size
		Object[] array = new Object[Integer.MAX_VALUE >> 2];
		System.out.println(array.length);
	}
}
