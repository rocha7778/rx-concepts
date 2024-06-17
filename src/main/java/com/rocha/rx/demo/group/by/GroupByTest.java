package com.rocha.rx.demo.group.by;

import com.rocha.rx.demo.data.Person;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GroupByTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		 
		/* Observable.fromIterable(Person.persons())
		 .map(person -> compute(person.getName()))
		 .subscribe(System.out::println);
		 
		 */
		 Observable.fromIterable(Person.persons())
		 .flatMap(person -> Observable.just(person)
				 .subscribeOn(Schedulers.computation())
				 .map(p -> compute(p.getName())))
		 .subscribe(System.out::println);
		 
		 Thread.sleep(1500);
	}
	
	public static String compute(String name) {
		
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		return name.toUpperCase() + " Thread " + Thread.currentThread().getName();
		
	}

}
