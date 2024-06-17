package com.rocha.rx.demo.test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ObservableTestCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable.range(1, 20).map(i -> i * i).subscribe(i -> System.out.println(i));
		
		List<String> list = new ArrayList<>();
		
		list.add("Natanael");
		list.add("Carlos");
		list.add("Paola");
		
		Observable<String> source = Observable.defer(() -> Observable.fromIterable(list));
		
		source.subscribe(e -> System.out.println(e));
		
		list.add("Rocha");
		
		source.subscribe(e -> System.out.println(e));
		
		
		

	}

}
