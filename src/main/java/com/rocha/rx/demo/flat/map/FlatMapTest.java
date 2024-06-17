package com.rocha.rx.demo.flat.map;

import com.rocha.rx.demo.data.Person;

import io.reactivex.rxjava3.core.Observable;

public class FlatMapTest {

	public static void main(String[] args) {

		Observable
		.fromIterable(Person.persons())
		.flatMap(p -> Observable.fromArray(p.getName().split("")))
		.subscribe(System.out::println);

	}

}
