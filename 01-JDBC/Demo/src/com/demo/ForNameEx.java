package com.demo;

public class ForNameEx {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("hello World");
		Class.forName("com.demo.Demo");
	}

}

class Demo {
	static {
		System.out.println("Static Block Executed");
	}
	
	{
		System.out.println("Instance Block Executed.");
	}
}
