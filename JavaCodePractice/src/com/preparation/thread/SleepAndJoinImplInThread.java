package com.preparation.thread;

public class SleepAndJoinImplInThread {
	public static void main(String[] args) throws InterruptedException {
		Thread numberThread = new Thread(new NumberTask1());
		Thread letterThread = new Thread(new LetterTask1());
		numberThread.start();
		numberThread.join();
		letterThread.start();
		letterThread.join();
		System.out.println("Main finished");
	}
}

class NumberTask1 implements Runnable{
	@Override
	public void run() {
		for(int i = 1; i<=5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}	
}

class LetterTask1 implements Runnable{
	@Override
	public void run() {
		for(char i = 'A'; i<='E'; i++) {
			System.out.println(i);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}	
}