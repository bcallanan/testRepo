package com.brianc.testRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.brianc.testRepo.SortAddSalariesAverageExercise.Employee;

/**
 * Hello world!
 *
 */
public class Java8LambdaSortUserObject {

	protected static class Employee {
		private String name;
		private Integer id;
		private Float salary;
		public Employee( String name, Integer id,  Float salary) {
			this.name = name;
			this.id = id;
			this.salary = salary;
		}
		public String toString() {
			
			return "name: " + name;  
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Float getSalary() {
			return salary;
		}
		public void setSalary(Float salary) {
			this.salary = salary;
		}
		
	}

	public static void main(String[] args) throws IOException {

    	Employee[] empArray = {
			new Employee( "joe", 22, 150000f),
			new Employee( "sally", 27, 100000f),
			new Employee( "bob", 40, 150000f),
			new Employee( "nancy", 55, 100000f),
			new Employee( "fred", 18, 100000f)};

    	
    	List<Employee> emps = new ArrayList<>( Arrays.asList( empArray));
    	
    	emps.stream()
    	    .sorted( (emp1, emp2)  -> emp1.getName().compareTo( emp2.getName() ))
    	    .forEach( System.out::println);
    }
}
