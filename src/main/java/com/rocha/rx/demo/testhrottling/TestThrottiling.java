package com.rocha.rx.demo.testhrottling;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class TestThrottiling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Observable.interval(500, TimeUnit.MILLISECONDS)
	    .throttleFirst(1, TimeUnit.SECONDS)
	    .subscribe(item -> System.out.println("throttleFirst: " + item));
		
		
		
		Thread.sleep(10000);

	}

}
