package com.brianc.testRepo;


class Rectangle extends Shape {
	 
    int length, width;
 
    Rectangle(int length, int width, String name) {
        super(name);
 
        this.length = length;
        this.width = width;
    }
 
    @Override
    public void draw() { System.out.println( getName() + " has been drawn "); }
 
    @Override 
    public double area() { return (double)(length * width); }
}

class Circle extends Shape {
	 
    int radius;
    double pi = 3.14;

    Circle( int radius, String name) {
        super(name);
 
        this.radius = radius;
    }
 
    @Override
    public void draw() { System.out.println( getName() + " has been drawn "); }
 
    @Override 
    public double area() { return (double)(pi * radius * radius); }
}

public abstract class Shape {

	private String name;

	public Shape(String name) {
		this.name = name;
	}
	public abstract double area();
	public abstract void draw();

	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	public void moveTo( int x, int y ) {
		
		System.out.println( this.name + " has been moved to x:" + x + " and y:" + y);
	}
	
    public static void main(String[] args) {

    	// Create a Rectangle
        Shape shape = new Rectangle(2, 3, "Rectangle");
 
        System.out.println("Area of the " + shape.getName() + ": " + shape.area());
 
        shape.draw();
        
        shape.moveTo(1, 2);
 
        System.out.println(" ");
 
        shape = new Circle(2, "Circle");
 
        System.out.println("Area of circle: " + shape.area());
        
        shape.draw();

        shape.moveTo(2, 4);
    }
}
