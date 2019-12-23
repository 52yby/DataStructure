package com.dyg.datestucture.hash;

public class Employee {

	private   int  id;
	private  String name;
  Employee  next;
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee getNext() {
		return next;
	}
	public void setNext(Employee next) {
		this.next = next;
	}
	
}
