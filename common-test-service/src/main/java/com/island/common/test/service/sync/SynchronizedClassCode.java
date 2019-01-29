package com.island.common.test.service.sync;

public class SynchronizedClassCode {

    private static int flag = 1;

    public synchronized static void accum(int time) {
        flag++;
        System.out.println("Thread: " + Thread.currentThread().getName() + " /Current flag: " + flag);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag--;
        System.out.println("Thread: " + Thread.currentThread().getName() + " /Current flag: " + flag);
    }

    public void acc() {
        System.out.println("非同步方法:" + flag);
    }

    public synchronized void ac() {
        flag--;
        System.out.println("ac:" + flag);
    }

    public static void main(String[] args) {
		/*final Test3 test = new Test3(); ---同一个对象  监视范围为对象的线程可以正常阻塞
		new Thread("one"){
			public void run(){
				test.accum(2000);
			}
		}.start();
		new Thread("two"){
			public void run(){
				test.accum(10);
			}
		}.start();*/
		/*new Thread("tt"){
			public void run(){
				test.acc();
			}
		}.start();*/
        new Thread("one") {
            public void run() {
                new SynchronizedClassCode().accum(2000);
            }
        }.start();
        new Thread("two") {
            public void run() {
                new SynchronizedClassCode().accum(100);
            }
        }.start();
        new Thread("tt") {
            public void run() {
                new SynchronizedClassCode().acc();
            }
        }.start();
        new Thread("three") {
            public void run() {
                new SynchronizedClassCode().ac();
            }
        }.start();
        new Thread("four") {
            public void run() {
                new SynchronizedClassCode().ac();
            }
        }.start();

    }
}