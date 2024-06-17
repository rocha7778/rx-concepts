package com.rocha.rx.infinite.stream;

import java.math.BigInteger;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class InfiniteStreamTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// BROKEN! Don't do this
		Observable<BigInteger> naturalNumbers = Observable.create(emitter -> {
			Runnable r = () -> {

				BigInteger i = BigInteger.ZERO;
				while (!emitter.isDisposed()) {
					if (emitter.isDisposed()) {
						return;
					}
					emitter.onNext(i);
					i = i.add(BigInteger.ONE);
				}
			};
			new Thread(r).start();
		});

		Disposable disposable = naturalNumbers
				.subscribe(x -> System.out.println(x), 
						Throwable::printStackTrace,
				        () -> System.out.println("Completed"));
		
		
		// Unsubscribe after 3 seconds
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                disposable.dispose(); // Unsubscribe from the Observable
                System.out.println("Unsubscribed from the Observable");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

	}

}
