package com.rocha.rx.demo.zip.test;

import io.reactivex.rxjava3.core.Observable;

public class ZipOperator {
	
	public static void main(String[] args) {
		
		Observable<String> observable1 = Observable.just("A", "B", "C");
        Observable<Integer> observable2 = Observable.just(1, 2, 3);
        Observable<String> observable3 = Observable.just("One", "Two", "Three");
        
        
        Observable.zip(observable1, observable2, observable3, 
                (letters, numbers, english) -> letters + "-" + numbers + "-" + english)
                .subscribe(
                        result -> System.out.println("Received: " + result),
                        throwable -> System.err.println("Error: " + throwable),
                        () -> System.out.println("Completed")
                );
        
        observable1.first("letter").subscribe(System.out::println);
		
	}

}
