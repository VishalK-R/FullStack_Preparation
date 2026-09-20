package com.preparation.thread;

public class ImplementRunnable {
	public static void main(String[] args) {
		Thread numberThread = new Thread(new NumberTask());
		Thread letterThread = new Thread(new LetterTask());
		numberThread.start();
		letterThread.start();
	}
}

class NumberTask implements Runnable{
	@Override
	public void run() {
		for(int i = 1; i<=5; i++) {
			System.out.println(i);
		}
	}	
}

class LetterTask implements Runnable{
	@Override
	public void run() {
		for(char i = 'A'; i<='E'; i++) {
			System.out.println(i);
		}
	}	
}