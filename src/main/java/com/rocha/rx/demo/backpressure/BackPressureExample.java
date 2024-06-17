package com.rocha.rx.demo.backpressure;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressureExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		Observable.range(1, 10)
		.map(e ->{
			sleep(500);
			System.out.println("Produced item is: " + e + " : " + Thread.currentThread().getName());
			return e;
		})
		.observeOn(Schedulers.io())
		.subscribe(e ->{
			
			sleep(1000);
			System.out.println("Consumed item is: " + e + " : " + Thread.currentThread().getName());
		});
		
		sleep(25000);
	}
	
	
	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
