package se.lexicon.tonygranath.model;

public class Person {
	private final int id;
	private String firstName;
	private String lastName;
	private String email;

	public Person(int id, String firstName, String lastName, String email) {
		this.id = id;
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName != null)
			this.firstName = firstName;
		else
			throw new RuntimeException("firstName was null.");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName != null)
			this.lastName = lastName;
		else
			throw new RuntimeException("lastName was null.");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null)
			this.email = email;
		else
			throw new RuntimeException("email was null.");
	}

	public String getSummary() {
		return "{ id: " + id
				+ ",\nfirstName: " + firstName
				+ ",\nlastName: " + lastName
				+ ",\nemail: " + email + " }";
	}
}
