package com.rocha.rx.demo.backpressure;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressureExample2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Flowable.range(1, 10)
		.map(e ->{
			System.out.println("Produced item is: " + e + " : " + Thread.currentThread().getName());
			return e;
		})
		.observeOn(Schedulers.io())
		.subscribe(new Subscriber<Integer>() {

			Subscription s;
			AtomicInteger count = new AtomicInteger();

			@Override
			public void onNext(Integer item) {
				System.out.println("The subscriber consumed: " +item);
				
				if((count.getAndIncrement() % 2) == 0) {
					System.out.println("Asking for the next two items");
					s.request(2);
				}
			}

			@Override
			public void onError(Throwable throwable) {
				
				throwable.printStackTrace();
				
			}

			@Override
			public void onComplete() {
				System.out.println("Consumer finished");
				
			}

			public void onSubscribe(Subscription s) {
				// TODO Auto-generated method stub
				this.s = s;
				System.out.println("Asking for 2 elements");
				this.s.request(2);
				
			}
			
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
