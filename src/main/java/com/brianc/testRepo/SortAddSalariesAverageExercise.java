package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.brianc.testRepo.Java8LambdaSortUserObject.Employee;

/**
 * Hello world!
 *
 */
public class SortAddSalariesAverageExercise 
{
	protected static class Person {
		private String name;
		private Integer age;
		public Person( String name, Integer age) {
			this.name = name;
			this.age = age;
		}
	}
	protected static class Car {
		private String make;
		private String color;
		private Float price;
		public Car( String make, String color, Float price) {
			this.make = make;
			this.color = color;
			this.price = price;
		}
		public String toString() {
			
			return "Make: " + make + ", color: " + color + ", price: " + price;  
		}
	}
	protected static class Employee {
		private String name;
		private Integer age;
		private String title;
		private Float salary;
		public Employee( String name, Integer age, String title, Float salary) {
			this.name = name;
			this.age = age;
			this.title = title;
			this.salary = salary;
		}
		public String toString() {
			
			return "name: " + name + ", age: " + age + ", title: " + title;  
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Float getSalary() {
			return salary;
		}
		public void setSalary(Float salary) {
			this.salary = salary;
		}
	}

    public static void main( String[] args ) {
    	
    	Person[] pepleArray = {
    			new Person( "jeff", 42),
    			new Person( "annie", 22),
    			new Person( "Jefferson", 28),
    			new Person( "Sam", 56),
    			new Person( "Sam", 16)};
    			
    	List<Person> people = new ArrayList<>( Arrays.asList( pepleArray));
    	List<String> peopleNames = people
    			.stream()
    			.map((person) -> person.name)
    			.collect( Collectors.toList());
    		
    	System.out.println( "people" + peopleNames);
    	Car[] carArray = {
			new Car( "chevy", "red", 42000f),
			new Car( "ford", "blue", 22000f),
			new Car( "toyota", "green", 28000f),
			new Car( "renault", "white", 56000f),
			new Car( "volvo", "broan", 16000f)};
			
    	List<Car> cars = new ArrayList<>( Arrays.asList( carArray));
    	List<Car> bluecars = cars
    			.stream()
    			.filter( (car) -> car.color == "blue" )
    			.collect( Collectors.toList());
    	System.out.println( "bluecars" + bluecars);

    	Employee[] empArray = {
			new Employee( "joe", 22, "developer", 150000f),
			new Employee( "sally", 27, "engineer", 100000f),
			new Employee( "bob", 40, "developer", 150000f),
			new Employee( "nancy", 55, "service tech", 100000f),
			new Employee( "fred", 18, "teacher", 100000f)};
			
    	List<Employee> emps = new ArrayList<>( Arrays.asList( empArray));
    	
    	emps.stream()
		.sorted( (emp1, emp2)  -> emp1.getName().compareTo( emp2.getName() ))
		.forEach( System.out::println);

    	Float sumOfEmps = emps
    			.stream()
    			.map( (employee) -> employee.salary)
    			.reduce( 0f, (acc, x) -> acc + x );
    			
    	System.out.println( "emps" + sumOfEmps);
    	
    	Float diffSalaryForDevs = emps
    			.stream()
    			.filter( (employee) -> employee.title == "developer" )
    			.map( (employee) -> employee.salary)
    			.reduce( 0f, (acc, x) -> acc + x );
    	System.out.println( "emps" + diffSalaryForDevs);

    	// Sortby Name
       	emps.stream()
	    .sorted( (emp1, emp2)  -> emp1.getName().compareTo( emp2.getName() ))
	    .forEach( System.out::println);

       	// Count developers
       	Long countDevs = emps
    			.stream()
    			.filter( (employee) -> employee.title == "developer" )
    			.collect( Collectors.counting());
    	System.out.println( "count" + countDevs);
   		
    	Float average = diffSalaryForDevs / countDevs;
    	System.out.println( "emps average" + average);

    	// Group by job title
    	// determine average salary
    	Map<String, Object> averageSalaryMap = emps
    			.stream()
    			.collect( Collectors.groupingBy(
    					(employee) -> employee.title
    			))
    			.entrySet()
    			.stream()
    			.collect( Collectors.toMap(
    					(entry) -> entry.getKey(),
    					(entry) -> entry.getValue()
    						.stream()
    						.map((employee) -> employee.salary)
    						.reduce( 0f, (acc, x ) -> acc + x) / entry.getValue().size() 
    						));
    	
    	System.out.println( "avg" + averageSalaryMap);
    }
}
