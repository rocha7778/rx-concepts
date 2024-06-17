package com.rocha.rx.demo;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TestParalelisom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		synchronous();

 		System.out.println("Another execution");
 		System.out.println("Another execution");
 		System.out.println("Another execution");
 		
 		
		aSynchronous();

	}

	private static void aSynchronous() {
		Flowable.range(1, 10)
		.flatMap(i -> Flowable.just(i).subscribeOn(Schedulers.computation()).map(v -> {

			System.out.println("tread name: " + Thread.currentThread().getName());

			return v * v;

		})).blockingSubscribe( i ->{
			
			System.out.println("Item: " + i);
			System.out.println("tread name: " + Thread.currentThread().getName());
		});
	}

	private static void synchronous() {
		Flowable.range(1, 10)
		.observeOn(Schedulers.computation()).map(v -> {
			System.out.println("tread name: " + Thread.currentThread().getName());
			return v * v;
		}).blockingSubscribe(i -> {
			System.out.println("Item: " + i);
			System.out.println("tread name: " + Thread.currentThread().getName());
		});
	}

}
