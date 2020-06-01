package com.interview.patterns.builder;

import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private Address address;
	private List<IdentityProof> ids;
	public static final Builder builder = new Builder();

	public Person(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.address = builder.address;
		this.ids = builder.ids;
	}

	public static class Builder {
		private String firstName;
		private String lastName;
		private Address address;
		private List<IdentityProof> ids;
		
		public Builder setIds(List<IdentityProof> ids) {
			this.ids = ids;
			return this;
		}
		
		

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
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", ids=" + ids
				+ "]";
	}

}