package com.island.common.test.service.sync;

public class SyncTest {

	public static int COUNTER = 0;

	public static void main(String[] args) throws Exception {
		Worker worker1 = new Worker("workerman");
		Worker worker2 = new Worker("workerman2");
		worker1.start();
		worker2.start();
	}

	public static Integer countAdd() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			Thread.sleep(10);
			SyncTest.COUNTER++;
			System.out.println(SyncTest.COUNTER);
		}
		return SyncTest.COUNTER;
	}

	public static Integer countMinus() throws InterruptedException {
		for (int i = 0; i < 50; i++) {
			Thread.sleep(10);
			SyncTest.COUNTER--;
			System.out.println(SyncTest.COUNTER);
		}
		return SyncTest.COUNTER;
	}

}
