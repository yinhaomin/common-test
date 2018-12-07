package com.island.common.test.service.sync;

/**
 * 运行者
 * 
 * @author DAVID YIN
 *
 */
public class Worker extends Thread {

	private String workerName;

	Byte byteValue = new Byte((byte) 0);

	public Worker(String workerName) {
		this.workerName = workerName;
	}

	@Override
	public void run() {
		// synchronized (byteValue) {
		// if (this.workerName.equals("workerman")) {
		try {
			// SyncTest.countAdd();
			synchronized (SyncTest.countAdd()) {
				// System.out.println(SyncTest.COUNTER);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// } else {
		// try {
		// // SyncTest.countMinus();
		// synchronized (SyncTest.countAdd()) {
		// // System.out.println(SyncTest.COUNTER);
		// }
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// synchronized (byteValue) {
		// System.out.println(SyncTest.COUNTER);
		// }
		// }
	}

}
