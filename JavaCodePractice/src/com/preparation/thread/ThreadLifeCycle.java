package com.preparation.thread;

public class ThreadLifeCycle {
	public static void main(String[] args) throws InterruptedException {

        Thread threadObj = new Thread(() -> {
            try {
                System.out.println("Worker started");

                Thread.sleep(2000);

                System.out.println("Worker finished sleeping");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("1. " + threadObj.getState());

        threadObj.start();

        System.out.println("2. " + threadObj.getState());
        //put main thread to sleep for 500ms so that it can observe worker thread sleeping 
        Thread.sleep(500);

        System.out.println("3. " + threadObj.getState());
        //If below line is commented Mainthread executes Other instruction below it and may not be able to see terminated state as it will be in TIMED_WAITING
        threadObj.join();

        System.out.println("4. " + threadObj.getState());
        
        System.out.println("5. MainThread " + Thread.currentThread().getState());
        
        System.out.println("6. Main thread finished executing");
    }
}
