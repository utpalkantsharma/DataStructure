package com.interview.patterns.builder;

public class TestPersonBuilder {

	public static void main(String[] args) {
		Person person = Person.builder.setFirstName("Utpal").setLastName("Sharma")
				.setAddress(Address.builder.setCity("Bangalore").setState("Bangalore").setZip("584003").build())
				.setIds(IdListBuilder.newBuilder().withNewList()
						.addId().setType("voter id").setUniqueNumber("123v34555").addIdToList()
						.addId().setType("pan card").setUniqueNumber("ce34343adfds").addIdToList()
						.done())
				.build();
		System.out.println(person);
	}

}
