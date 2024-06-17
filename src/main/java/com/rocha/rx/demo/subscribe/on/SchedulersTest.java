package com.rocha.rx.demo.subscribe.on;

import java.util.concurrent.TimeUnit;

import com.rocha.rx.demo.data.Person;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchedulersTest {

	public static void main(String[] args) throws InterruptedException {

		 Observable<Person> src = Observable.fromIterable(Person.persons())
                 .concatMap(person -> Observable.just(person)
                                                .delay(1000, TimeUnit.MILLISECONDS, Schedulers.trampoline()))
                 .cache();
		
		long startTime = System.currentTimeMillis();
		
		src.subscribe(SchedulersTest::compute);
		src.subscribe(SchedulersTest::compute);
		src.subscribe(SchedulersTest::compute);
		src.subscribe(SchedulersTest::compute);
		src.subscribe(SchedulersTest::compute);

		System.out.println("Numbers of core" + Runtime.getRuntime().availableProcessors());
		
		long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        
        double totalTimeSeconds = totalTime / 1000.0;
        
  
        System.out.println("Total time consumed: " + totalTimeSeconds + " seconds");
	

	}

	public static void compute(Person person) throws InterruptedException {
		System.out.println(
				"Getting the name: " + person.getName() + " Computation Done By: " + Thread.currentThread().getName());
	}

}
