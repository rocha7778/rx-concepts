package com.rocha.rx.demo;

import io.reactivex.rxjava3.core.Observable;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable.create(emitter -> {
			while (!emitter.isDisposed()) {
				long time = System.currentTimeMillis();
				emitter.onNext(time);
				if (time % 2 != 0) {
					emitter.onError(new IllegalStateException("Odd millisecond!"));
					break;
				}
			}
		}).subscribe(System.out::println, Throwable::printStackTrace);

	}

}
