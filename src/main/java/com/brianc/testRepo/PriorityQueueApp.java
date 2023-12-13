package com.brianc.testRepo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Hello world!
 *
 */
public class PriorityQueueApp {
	public static void main(String...args) {

		PriorityQueue<Person> pQueue = new PriorityQueue<> (
			Comparator.comparing( (Person p) -> p.age )
		);
		
		pQueue.offer( new Person(20, "joe") );
		pQueue.offer( new Person(30, "fred") );
		pQueue.offer( new Person(20, "sally") );
		System.out.println( pQueue.poll().age);

		PriorityQueue<Person> pQueue1 = new PriorityQueue<> ( (p1, p2) -> p1.age - p2.age );
		pQueue1.offer( new Person(20, "joe") );
		pQueue1.offer( new Person(30, "fred") );
		pQueue1.offer( new Person(20, "sally") );
		System.out.println( pQueue1.poll().age);

		PriorityQueue<Person> pQueue2 = new PriorityQueue<> ( (p1, p2) -> p2.age - p1.age );
		pQueue2.offer( new Person(20, "joe") );
		pQueue2.offer( new Person(30, "fred") );
		pQueue2.offer( new Person(20, "sally") );
		System.out.println( pQueue2.poll().age);

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
			
		
	}
}
