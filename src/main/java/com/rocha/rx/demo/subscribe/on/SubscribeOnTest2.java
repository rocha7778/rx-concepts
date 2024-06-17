package com.rocha.rx.demo.subscribe.on;

import com.rocha.rx.demo.data.Person;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOnTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Observable.fromIterable(Person.persons()).subscribeOn(Schedulers.computation())
				.map(p -> p.getName().toUpperCase())
				.doOnNext(e -> System.out.println("Name of thread: " + Thread.currentThread().getName()))
				.observeOn(Schedulers.newThread())
				.subscribe(e -> printname(e));

		Thread.sleep(3000);
	}

	private static void printname(String e) {
		// TODO Auto-generated method stub
		System.out.println("Getting the name: " + e + " Computation Done By: " + Thread.currentThread().getName());

	}

}
