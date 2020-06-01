package com.interview.patterns.builder;

public class IdentityProof {

	private String type;
	private String uniqueNumber;
	public static Builder builder = new Builder();

	public IdentityProof(Builder builder2) {
		this.type = builder2.type;
		this.uniqueNumber = builder2.uniqueNumber;
	}

	public static class Builder {
		private String type;
		private String uniqueNumber;
		private IdListBuilder idListBuilder;

		public IdListBuilder addIdToList() {
			this.idListBuilder.addId(this.build());
			return this.idListBuilder;
		}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}

		public Builder setUniqueNumber(String uniqueNumber) {
			this.uniqueNumber = uniqueNumber;
			return this;
		}

		public IdentityProof build() {
			return new IdentityProof(this);
		}

		public void idListBuilder(IdListBuilder idListBuilder2) {
			this.idListBuilder = idListBuilder2;

		}

	}

	@Override
	public String toString() {
		return " [type=" + type + ", uniqueNumber=" + uniqueNumber + "]";
	}

}
