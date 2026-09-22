package com.preparation.thread;

public class SynchronizedCounterExample {
	static int count = 0;
	/**
	 * Without synchronized the count will vary as both thread would have accessed same value of count
	 * 
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread threadA = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        });

        Thread threadB = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("Final count: " + count);
    }
}
