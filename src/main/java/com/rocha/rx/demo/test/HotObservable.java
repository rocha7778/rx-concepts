package com.rocha.rx.demo.test;

import io.reactivex.rxjava3.core.Observable;

public class HotObservable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observable<Integer> coldObservable = Observable.create(emitter -> {
            System.out.println("Generating numbers");
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        });

        // First subscription
        coldObservable.subscribe(item -> System.out.println("Observer 1: " + item));

        // Second subscription
        coldObservable.subscribe(item -> System.out.println("Observer 2: " + item));
        
        Observable<Integer> number = Observable.range(1, 30).filter(i ->i%2==0).scan((a,b) -> a+b);
        
        number.subscribe(i -> System.out.println("Numbers "+i));

	}

}
