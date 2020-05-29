package com.interview.patterns.builder;

public class Address {
	
	public String city;
	public String state;
	public String zip;
	
	public Address(Builder addressBuilder) {
		this.city = addressBuilder.city;
		this.state = addressBuilder.state;
		this.zip = addressBuilder.zip;
	}
	
	public static class Builder{
		public String city;
		public String state;
		public String zip;
		
		public Builder setCity(String city) {
			this.city = city;
			return this;
		}
		
		public Builder setState(String state) {
			this.state = state;
			return this;
		}
		
		public Builder setZip(String zip) {
			this.zip = zip;
			return this;
		}
		
		public Address build() {
			return new Address(this);
		}
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
	

}
