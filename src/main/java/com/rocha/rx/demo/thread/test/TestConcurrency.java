package com.rocha.rx.demo.thread.test;

import io.reactivex.rxjava3.core.Observable;

public class TestConcurrency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var source1 = Observable.create(s -> {
				s.onNext("one");
				s.onNext("two");
				s.onNext("three");
				s.onNext("four");
				s.onComplete();
		});
		
		
		var source2 = Observable.create(s -> {
			s.onNext("five");
			s.onNext("six");
			s.onNext("sevent");
			s.onNext("eigth");
			s.onComplete();
	});

	
		Observable.zip(source1, source2, (s1, s2) -> s1 + " " + s2)
        .subscribe(
            item -> System.out.println("Received: " + item),
            throwable -> System.err.println("Error: " + throwable),
            () -> System.out.println("Completed")
        );
		

	}

}
