package se.lexicon.tonygranath.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
	private Person testPerson;
	private final static int ID = 1;
	private final static String FIRSTNAME = "Sverker";
	private final static String LASTNAME = "Johansson";
	private final static String EMAIL = "test@test.se";

	private final static String USERNAME = "testuser";
	private final static String PASSWORD = "testpwd";
	private final static AppRole ROLE = AppRole.ROLE_APP_USER;
	private AppUser testUser;

	@Before
	public void setUp() {
		testUser = new AppUser(USERNAME, PASSWORD, ROLE);
		testPerson = new Person(ID, FIRSTNAME, LASTNAME, EMAIL, testUser);
	}

	//also tests all getters
	@Test
	public void testPerson_successfully_instantiated() {
		assertEquals(testPerson.getId(), ID);
		assertEquals(testPerson.getFirstName(), FIRSTNAME);
		assertEquals(testPerson.getLastName(), LASTNAME);
		assertEquals(testPerson.getEmail(), EMAIL);
		assertEquals(testPerson.getCredentials(), testUser);
	}

	@Test
	public void testUser_successfully_instantiated() {
		assertEquals(USERNAME, testUser.getUsername());
		assertEquals(PASSWORD, testUser.getPassword());
		assertEquals(ROLE, testUser.getRole());
	}

	@Test(expected = RuntimeException.class)
	public void given_null_firstName_constructor_throws_runtime_exception() {
		testPerson = new Person(ID, null, LASTNAME, EMAIL);
	}

	@Test(expected = RuntimeException.class)
	public void given_null_lastName_constructor_throws_runtime_exception() {
		testPerson = new Person(ID, FIRSTNAME, null, EMAIL);
	}

	@Test(expected = RuntimeException.class)
	public void given_null_email_constructor_throws_runtime_exception() {
		testPerson = new Person(ID, FIRSTNAME, LASTNAME, null);
	}

	@Test
	public void setFirstName() {
		final String newName = "Lasse";
		testPerson.setFirstName(newName);
		assertEquals(newName, testPerson.getFirstName());
	}

	@Test
	public void setLastName() {
		final String newName = "Andersson";
		testPerson.setLastName(newName);
		assertEquals(newName, testPerson.getLastName());
	}

	@Test
	public void setEmail() {
		final String newEmail = "a@b.cd";
		testPerson.setEmail(newEmail);
		assertEquals(newEmail, testPerson.getEmail());
	}

    @Test
    public void setCredentials() {
		AppRole newRole = AppRole.ROLE_APP_ADMIN;
		AppUser test = new AppUser("changedUsername", "changedPassword", newRole);
		testPerson.setCredentials(test);
		assertEquals(testPerson.getCredentials(), test);
    }

    @Test
    public void testToString() {
		assertEquals(testPerson.toString(),
				"Person{id=" + ID +
							", firstName='" + FIRSTNAME +
							"', lastName='" + LASTNAME +
							"', email='" + EMAIL +
						"'}");
    }

    @Test
    public void testEquals() {
		Person test = new Person(ID, FIRSTNAME, LASTNAME, EMAIL);
		assertTrue(testPerson.equals(test));
		test = new Person(1001033, FIRSTNAME, LASTNAME, EMAIL);
		assertFalse(testPerson.equals(test));
    }

    @Test
    public void testHashCode() {
		//I don't know how to test this so I just print it out
		System.out.println(testPerson.hashCode());
    }
}

