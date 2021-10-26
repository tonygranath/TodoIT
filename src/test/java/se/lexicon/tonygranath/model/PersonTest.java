package se.lexicon.tonygranath.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
	private Person p;
	private final int ID = 1;
	private final String FIRSTNAME = "Sverker";
	private final String LASTNAME = "Johansson";
	private final String EMAIL = "test@test.se";

	@Before
	public void setUp() {
		p = new Person(ID, FIRSTNAME, LASTNAME, EMAIL);
	}

	@Test
	public void person_successfully_instantiated() {
		assertEquals(p.getId(), ID);
		assertEquals(p.getFirstName(), FIRSTNAME);
		assertEquals(p.getLastName(), LASTNAME);
		assertEquals(p.getEmail(), EMAIL);
	}

	@Test
	public void testGetSummary() {
		assertEquals("{ id: " + ID + ",\n" +
						"firstName: " + FIRSTNAME + ",\n" +
						"lastName: " + LASTNAME + ",\n" +
						"email: " + EMAIL + " }",
				p.getSummary());
	}
	@Test(expected = RuntimeException.class)
	public void given_null_firstName_constructor_throws_runtime_exception() {
		p = new Person(ID, null, LASTNAME, EMAIL);
	}

	@Test(expected = RuntimeException.class)
	public void given_null_lastName_constructor_throws_runtime_exception() {
		p = new Person(ID, FIRSTNAME, null, EMAIL);
	}

	@Test(expected = RuntimeException.class)
	public void given_null_email_constructor_throws_runtime_exception() {
		p = new Person(ID, FIRSTNAME, LASTNAME, null);
	}
}