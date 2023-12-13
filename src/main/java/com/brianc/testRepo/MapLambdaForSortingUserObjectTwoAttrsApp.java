package com.brianc.testRepo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class MapLambdaForSortingUserObjectTwoAttrsApp {
	public static void main(String...args) {

		Map<Person,Integer> personMap = new HashMap<>();
		
		personMap.put( new Person(20, "joe"), 25 );
		personMap.put( new Person(30, "fred"), 60 );
		personMap.put( new Person(20, "sally"),80 );
		
		personMap.entrySet()
			.stream()
			.sorted(( key1, key2) -> key1.getKey().age - key2.getKey().age )
			.forEach( System.out::println);

		System.out.println();
		
		personMap.entrySet()
		.stream()
		.sorted(( key1, key2) -> key1.getKey().name.compareToIgnoreCase( key2.getKey().name) )
		.forEach( System.out::println);

		System.out.println();

		personMap.entrySet()
		.stream()
		.sorted(( key1, key2) -> key1.getKey().age == key2.getKey().age ?
				key1.getValue() - key2.getValue() :  key1.getKey().age - key2.getKey().age )
		.forEach( System.out::println);

	}

	static class  Person {
		private int age;
		private String name;
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}
			
		
	}
}
