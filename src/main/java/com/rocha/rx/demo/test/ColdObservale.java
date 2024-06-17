package com.rocha.rx.demo.test;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class ColdObservale {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		 PublishSubject<Integer> hotObservable = PublishSubject.create();

	        // Start emitting items immediately
	        new Thread(() -> {
	            try {
	                for (int i = 1; i <= 5; i++) {
	                    Thread.sleep(1000);
	                    System.out.println("Emitting " + i);
	                    hotObservable.onNext(i);
	                }
	                hotObservable.onComplete();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }).start();

	        // First subscription (immediate)
	        hotObservable.subscribe(item -> System.out.println("Observer 1: " + item));

	        // Delay the second subscription
	        Thread.sleep(2500);

	        // Second subscription (late)
	        hotObservable.subscribe(item -> System.out.println("Observer 2: " + item));

	}

}
