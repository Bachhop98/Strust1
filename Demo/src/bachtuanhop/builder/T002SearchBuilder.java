package bachtuanhop.builder;

public class T002SearchBuilder {
	private String name;
	private String sex;
	private String birthdayFrom;
	private String birthdayTo;
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getBirthdayFrom() {
		return birthdayFrom;
	}
	public String getBirthdayTo() {
		return birthdayTo;
	}
	private T002SearchBuilder(Builder builder) {
		this.name = builder.name;
		this.sex = builder.sex;
		this.birthdayFrom = builder.birthdayFrom;
		this.birthdayTo = builder.birthdayTo;
	}
	public static class Builder {
		private String name;
		private String sex;
		private String birthdayFrom;
		private String birthdayTo;
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setSex(String sex) {
			this.sex = sex;
			return this;
		}
		public Builder setBirthdayFrom(String birthdayFrom) {
			this.birthdayFrom = birthdayFrom;
			return this;
		}
		public Builder setBirthdayTo(String birthdayTo) {
			this.birthdayTo = birthdayTo;
			return this;
		}
		public T002SearchBuilder build() {
			return new T002SearchBuilder(this);
		}
		
	}
	

}
