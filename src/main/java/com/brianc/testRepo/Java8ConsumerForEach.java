package com.brianc.testRepo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 *
 */
public class Java8ConsumerForEach {

	public static void main(String[] args) {
		
		//creating sample Collection
		List<Integer> myList = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		//traversing through forEach method of Iterable with anonymous class
		myList.forEach( new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}

		});
		
		//traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
	}
}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}
}
