package com.vk.rico.data.structure.list;

import java.util.Arrays;

/**
 * 测试数组
 * 
 * @author liangxf
 *
 */
public class VkArrayTester {

	public static void main(String[] args) {
		// 创建一个空数组，数组元素个数为0
		String[] str = {};
		System.out.println(str.length);

		// 创建一个非空数组，数组元素个数是4，最后一个元素为null
		String[] str2 = { "a", "b", "", null };
		System.out.println(str2.length);

		// 数组也是对象，因为它可以访问到Object上的方法
		// 虚拟机自动创建了数组类型，可以把数组类型和8种基本数据类型一样， 当做java的内建类型。这种类型的命名规则是这样的：
		// 每一维度用一个[表示；开头两个[，就代表是二维数组。
		// [后面是数组中元素的类型(包括基本数据类型和引用数据类型)，如：[Ljava.lang.String;
		System.out.println(str2.getClass().getName());

		testArraycopy();
		// testCopyof();
	}

	public static void testArraycopy() {
		int[] src = { 2, 1, 3 };
		int[] dest = new int[src.length * 2];
		System.arraycopy(src, 1, dest, 2, src.length - 1);
		System.out.println(dest.getClass().getName());

		/**
		 * 以下情况将抛出IndexOutOfBoundsException 异常：<br/>
		 * srcPos为负数<br/>
		 * destPos为负数<br/>
		 * length为负数<br/>
		 * srcPos+length > src.length <br/>
		 * destPos+length > dest.length <br/>
		 */
		int[] dest1 = new int[1];
		System.arraycopy(src, 3, dest1, 1, 0);
	}

	public static void testCopyof() {
		// Long[] src = { 101L, 103L, 102L, null }; // 静态初始化数组
		Long[] src = new Long[3]; // 动态创建数组，数组中的元素还没有初始化
		Long[] dest1 = Arrays.copyOf(src, src.length);
		System.out.println(dest1.getClass().getName() + "\t" + dest1.length);
		if (src == dest1) { // 不相等
			System.out.println(true);
		}

		// 截断
		Long[] dest2 = Arrays.copyOf(src, 2);
		System.out.println(dest2.getClass().getName() + "\t" + dest2.length);

		// 填充null
		Long[] dest3 = Arrays.copyOf(src, 5);
		System.out.println(dest3.getClass().getName() + "\t" + dest3.length);
	}
}
