package se.lexicon.tonygranath.model;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class TodoItemTest {
	private final int PERSON_ID = 1;
	private final String PERSON_FIRSTNAME = "Greger";
	private final String PERSON_LASTNAME = "Johansson";
	private final String PERSON_EMAIL = "test@test.se";
	private Person testPerson;
	private final int ID = 1;
	private final String TITLE = "Title Test";
	private final String DESCRIPTION = "Description Test";
	private final LocalDate DEADLINE = LocalDate.parse("2022-10-30");
	private final boolean DONE = true;
	private TodoItem testItem;

	@Before
	public void setUp() {
		testPerson = new Person(PERSON_ID, PERSON_FIRSTNAME, PERSON_LASTNAME, PERSON_EMAIL);
		testItem = new TodoItem(ID, TITLE, DESCRIPTION, DEADLINE, DONE, testPerson);
	}

	@Test
	public void testPerson_successfully_instantiated() {
		assertEquals(PERSON_ID, testPerson.getId());
		assertEquals(PERSON_FIRSTNAME, testPerson.getFirstName());
		assertEquals(PERSON_LASTNAME, testPerson.getLastName());
		assertEquals(PERSON_EMAIL, testPerson.getEmail());
	}

	@Test
	public void testItem_successfully_instantiated() {
		assertEquals(ID, testItem.getId());
		assertEquals(TITLE, testItem.getTitle());
		assertEquals(DESCRIPTION, testItem.getTaskDescription());
		assertEquals(DEADLINE, testItem.getDeadLine());
		assertEquals(DONE, testItem.isDone());
		assertEquals(testPerson, testItem.getCreator());
	}

	@Test(expected = RuntimeException.class)
	public void given_null_parameter_setTitle_throws_runtime_exception() {
		testItem.setTitle(null);
	}

	@Test(expected = RuntimeException.class)
	public void given_empty_string_parameter_setTitle_throws_runtime_exception() {
		testItem.setTitle("");
	}

	@Test
	public void setTaskDescription() {
		assertEquals(DESCRIPTION, testItem.getTaskDescription());
		final String newDescription = "New task description";
		testItem.setTaskDescription(newDescription);
		assertEquals(newDescription, testItem.getTaskDescription());
	}

	@Test(expected = RuntimeException.class)
	public void given_null_parameter_setDeadLine_throws_runtime_exception() {
		testItem.setDeadLine(null);
	}

	@Test
	public void isDone() {
		assertTrue(testItem.isDone());
	}

	@Test
	public void setDone() {
		assertTrue(testItem.isDone());
		testItem.setDone(false);
		assertFalse(testItem.isDone());
	}

	@Test
	public void setCreator() {
		assertEquals(testPerson, testItem.getCreator());
		Person p = new Person(2, "Sven", "Hansson", "sven@hansson.se");
		testItem.setCreator(p);
		assertEquals(p, testItem.getCreator());
	}

	@Test
	public void isOverDue() {
		assertFalse(testItem.isOverDue());
		final LocalDate newDeadline = LocalDate.parse("1901-02-02");
		testItem.setDeadLine(newDeadline);
		assertTrue(testItem.isOverDue());
	}

	@Test
	public void getSummary() {
		assertEquals("{ id: " + ID + ",\n" +
				"title: " + TITLE +",\n" +
				"taskDescription: " + DESCRIPTION + ",\n" +
				"deadLine: " + DEADLINE + ",\n" +
				"done: " + DONE + ",\n" +
				"creator: { id: " + PERSON_ID + ",\n" +
				"firstName: " + PERSON_FIRSTNAME + ",\n" +
				"lastName: " + PERSON_LASTNAME + ",\n" +
				"email: " + PERSON_EMAIL + " } }",
				testItem.getSummary());
	}

	@Test
	public void setDeadline() {
		assertEquals(DEADLINE, testItem.getDeadLine());
		final LocalDate newDeadline = LocalDate.parse("1901-02-02");
		testItem.setDeadLine(newDeadline);
		assertEquals(newDeadline, testItem.getDeadLine());
	}

	@Test
	public void setTitle() {
		assertEquals(TITLE, testItem.getTitle());
		final String newTitle = "Changed title";
		testItem.setTitle(newTitle);
		assertEquals(newTitle, testItem.getTitle());
	}
}