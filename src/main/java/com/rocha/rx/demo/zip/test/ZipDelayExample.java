package com.rocha.rx.demo.zip.test;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ZipDelayExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Observable<String> task1 = Observable.just("Result from Task 1");
        Observable<String> task2 = Observable.just("Result from Task 2").delay(5, TimeUnit.SECONDS, Schedulers.trampoline());
        Observable<String> task3 = Observable.just("Result from Task 3");

        // Using zip operator to combine results from all three tasks
        Observable<String> combinedResult = Observable.zip(
                task1,
                task2,
                task3,
                (result1, result2, result3) ->
                        "Combined result: " + result1 + ", " + result2 + ", " + result3
        );

        // Subscribing to the combined result
        combinedResult.subscribe(
                result -> System.out.println("Final result: " + result),
                error -> System.err.println("Error: " + error.getMessage()),
                () -> System.out.println("All tasks completed successfully!")
        );
        

	}

}
