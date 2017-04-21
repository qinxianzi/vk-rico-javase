package com.vk.rico.data.structure.hash;

import java.util.Map;

import com.vk.rico.data.structure.hash.hashmap.VkHashMap;

public class VkHashMapTester {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 8：初始容量、0.75f：默认加载因子
		// this.loadFactor = 0.75f;
		// this.threshold = 16;
		// Map<String, String> val0 = new UebHashMap<String, String>();
		// val0.put("Val0", "Val0");

		// 初始化8个桶，阀值thresho=(int)8*0.75f=6（即当桶的数量达到6个的时候，将自动扩容），加载因子是0.75f
		Map<String, String> val = new VkHashMap<String, String>(8, 0.75f);
		val.put("Tester0", "Tester0");
		val.put("Tester1", "Tester1");
		val.put("Tester2", "Tester2");
		val.put("Tester3", "Tester3");
		val.put("Tester4", "Tester4");
		val.put("Tester5", "Tester5");
		/**
		 * 存储Tester6时，将扩容，浪费1个桶，扩容之后，容量翻倍：<br/>
		 * this.table = new Node[16]<br/>
		 * this.threshold = 16 * 0.75 = 12<br/>
		 * size = 7
		 */
		val.put("Tester6", "Tester6");

		val.put("Tester7", "Tester7");
		val.put("Tester8", "Tester8");
		val.put("Tester9", "Tester9");
		val.put("Tester10", "Tester10"); // 和Tester5发生hash碰撞，size自增1
		val.put("Tester11", "Tester11");// 和Tester6发生hash碰撞，size自增1
		/**
		 * 存储Tester12时，将扩容，扩容之后，容量翻倍：<br/>
		 * this.table = new Node[32]<br/>
		 * this.threshold = (oldThr << 1)，oldThr=12<br/>
		 * 和Tester7发生hash碰撞，size自增1
		 */
		val.put("Tester12", "Tester12");

		val.put("Tester13", "Tester13");
		val.put("Tester14", "Tester14");
		val.put("Tester15", "Tester15");
		val.put("Tester16", "Tester16");

		val.put("Tester17", "Tester17");
		val.put("Tester18", "Tester18");
		val.put("Tester19", "Tester19");
		val.put("Tester20", "Tester20");
		val.put("Tester21", "Tester21");
		val.put("Tester22", "Tester22");
		val.put("Tester23", "Tester23");

		int MIN_TREEIFY_CAPACITY = 64;
		int MAXIMUM_CAPACITY = 1 << 30;
		// System.out.println(MAXIMUM_CAPACITY);

		// System.out.println(Integer.toBinaryString(15));
		// System.out.println(Integer.toBinaryString(-15));
		// System.out.println(Integer.toBinaryString(-15 << 2));
		// System.out.println(-15 << 2);
		// System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
		// System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE); //
		// 4294967295个整数
		// System.out.println(1 << 30);
		// System.out.println(1 << 31);
		// System.out.println(1 << 32);

		int n = 8;// 1-7:7;8-16:15;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		System.out.println("n1 = " + n);
		System.out.println("n = " + ((n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1));

		System.out.println("3 >>> 16  = " + (900 >>> 16));

		String key = "您";
		int h;
		int k = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		// System.out.println("k = " + k);

		String[] strs = new String[4];
		strs[0] = "a";
		strs[1] = "b";
		strs[2] = "c";
		strs[3] = "d";
		System.out.println("strs.length = " + strs.length);
		System.out.println(tableSizeFor(8));
	}

	public static final int tableSizeFor(int cap) {
		int MAXIMUM_CAPACITY = 1 << 30;
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}
}
