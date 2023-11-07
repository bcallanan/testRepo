package com.brianc.testRepo.threading;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class ConcurrentModificationExceptionService {

	public static void main(String[] args) throws InterruptedException {
		    
		//List<String> myList = Arrays.asList( "1", "2", "3", "4", "5");
		List<String> myList = new CopyOnWriteArrayList<String>( new String[] {  "1", "2", "3", "4", "5" } );

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
		    	myList.remove(value);
		}

		//Map<String, String> myMap = new HashMap<String, String>();
		Map<String, String> myMap = new ConcurrentHashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");
				myMap.put("4", "4");
			}
		}
		
		//List<String> names = Arrays.asList("Java", "PHP", "SQL", "Angular 2");
		List<String> names = new CopyOnWriteArrayList<String>( new String[] {"Java", "PHP", "SQL", "Angular 2" } );
		List<String> first2Names = ((CopyOnWriteArrayList<String>) names).subList(0, 2);
		System.out.println(names + " , " + first2Names);

		names.set(1, "JavaScript");
		// check the output below. :)
		try { 
			System.out.println(names + " , " + first2Names);
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}

		// Let's modify the list size and get ConcurrentModificationException
		try { 
			names.add("NodeJS");
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}
		first2Names.add( "NodeJS");
		System.out.println(names + " , " + first2Names); // this line throws exception


	}
}
