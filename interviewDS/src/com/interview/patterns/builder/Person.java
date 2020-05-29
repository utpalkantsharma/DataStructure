package com.interview.patterns.builder;

public class Person {
	private String firstName;
	private String lastName;
	private Address address;

	public Person(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.address = builder.address;
	}

	public static class Builder {
		private String firstName;
		private String lastName;
		private Address address;

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setAddress(Address address) {
			this.address = address;
			return this;
		}

		public Person build() {
			return new Person(this);
		}

	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}

}