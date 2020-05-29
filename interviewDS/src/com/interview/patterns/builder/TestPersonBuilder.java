package com.interview.patterns.builder;

public class TestPersonBuilder {

	public static void main(String[] args) {
		Person person = Person.builder
							.setFirstName("Utpal")
							.setLastName("Sharma")
							.setAddress(Address.builder
									.setCity("Ranchi")
									.setState("Jharkhand")
									.setZip("584003")
									.build())
							.build();
		System.out.println(person);
	}

}
