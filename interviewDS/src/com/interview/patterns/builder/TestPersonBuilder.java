package com.interview.patterns.builder;

public class TestPersonBuilder {

	public static void main(String[] args) {
		Person person = new Person.Builder().setFirstName("Utpal").setLastName("Sharma")
				.setAddress(new Address.Builder().setCity("Ranchi").setState("Jharkhand").setZip("584003").build())
				.build();
		
		System.out.println(person);
	}
	


}
