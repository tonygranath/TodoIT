package se.lexicon.tonygranath.model;

import se.lexicon.tonygranath.sequencers.PersonIdSequencer;

import java.util.Objects;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private AppUser credentials;

	public Person(int id, String firstName, String lastName, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		this.id = id;
	}

	public Person(int id, String firstName, String lastName, String email, AppUser credentials) {
		this(id, firstName, lastName, email);
		setCredentials(credentials);
	}

	public Person() {
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

	public AppUser getCredentials() {
		return credentials;
	}

	public void setCredentials(AppUser credentials) {
		this.credentials = credentials;
	}

	@Override
	public String toString() {
		return "Person{" +
					"id=" + id +
					", firstName='" + firstName + '\'' +
					", lastName='" + lastName + '\'' +
					", email='" + email + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return id == person.id && firstName.equals(person.firstName) && lastName.equals(person.lastName) && email.equals(person.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, email);
	}
}
