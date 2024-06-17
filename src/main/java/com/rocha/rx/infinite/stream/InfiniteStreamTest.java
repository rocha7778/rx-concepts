package com.rocha.rx.infinite.stream;


import java.math.BigInteger;

import io.reactivex.rxjava3.core.Observable;

public class InfiniteStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BROKEN! Don't do this
		Observable<BigInteger> naturalNumbers = Observable.create(subscriber -> {
			BigInteger i = BigInteger.ZERO;
			while (true) { // don't do this!
				subscriber.onNext(i);
				i = i.add(BigInteger.ONE);
			}
		});
		naturalNumbers.subscribe(x -> System.out.println(x));
		
		System.out.println("algo");

	}

}
