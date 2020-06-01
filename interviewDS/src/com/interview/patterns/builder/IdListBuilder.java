package com.interview.patterns.builder;

import java.util.ArrayList;
import java.util.List;

public class IdListBuilder {

	private List<IdentityProof> ids;

	public static IdListBuilder newBuilder() {
		return new IdListBuilder();
	}

	private IdListBuilder() {
	}

	public IdListBuilder withNewList() {
		this.ids = new ArrayList<>();
		return this;
	}

	public IdentityProof.Builder addId() {
		IdentityProof.Builder builder = IdentityProof.builder;
		builder.idListBuilder(this);
		return builder;
	}

	public List<IdentityProof> done() {
		// test if there are 4 instances....
		return this.ids;
	}

	public IdListBuilder addId(IdentityProof id) {
		this.ids.add(id);
		return this;
	}

}
