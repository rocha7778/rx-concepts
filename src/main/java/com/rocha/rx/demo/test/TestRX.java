package com.rocha.rx.demo.test;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class TestRX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Flowable.just("Hello", "Rocha", "Guerrero").subscribe(System.out::println);

		Observable<String> source = Observable.create(e -> {
			e.onNext("Hello");
			e.onNext("RxJava");
		}).map(s -> s.toString().toUpperCase());

		source.subscribe(e -> System.out.println(e));
		
		
		Observable<Integer> integerObserver = new ObservableCreate < Integer > (new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
				// TODO Auto-generated method stub
				try {
					emitter.onNext(10);
					emitter.onNext(11);
					emitter.onComplete();
				} catch (Throwable t) {
					emitter.onError(t);

				}
			}

		});
		
		Observer<Integer> observer = new Observer<Integer>() {

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				System.out.println("Subscribed");
				
			}

			@Override
			public void onNext(@NonNull Integer t) {
				System.out.println("On next: " + t);
				
			}

			@Override
			public void onError(@NonNull Throwable e) {

				e.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("On completed: ");
				
			}
			
		};
		
		integerObserver.subscribe(observer);
		
	}

	
	

}
