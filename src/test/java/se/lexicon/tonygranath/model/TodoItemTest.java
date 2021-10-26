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
	private Person p;
	private final int ID = 1;
	private final String TITLE = "Title Test";
	private final String DESCRIPTION = "Description Test";
	private final LocalDate DEADLINE = LocalDate.parse("2020-10-30");
	private final boolean DONE = true;
	private TodoItem item;

	@Before
	public void setUp() {
		p = new Person(PERSON_ID, PERSON_FIRSTNAME, PERSON_LASTNAME, PERSON_EMAIL);
		item = new TodoItem(ID, TITLE, DESCRIPTION, DEADLINE, DONE, p);
	}

	@Test
	public void test_person_successfully_instantiated() {
		assertEquals(PERSON_ID, p.getId());
		assertEquals(PERSON_FIRSTNAME, p.getFirstName());
		assertEquals(PERSON_LASTNAME, p.getLastName());
		assertEquals(PERSON_EMAIL, p.getEmail());
	}

	@Test
	public void testItem_successfully_instantiated() {
		assertEquals(ID, item.getId());
		assertEquals(TITLE, item.getTitle());
		assertEquals(DESCRIPTION, item.getTaskDescription());
		assertEquals(DEADLINE, item.getDeadLine());
		assertEquals(DONE, item.isDone());
		assertEquals(p, item.getCreator());
	}

	@Test
	public void setTitle() {
	}

	@Test
	public void setTaskDescription() {
	}

	@Test
	public void setDeadLine() {
	}

	@Test
	public void isDone() {
		assertTrue(item.isDone());
	}

	@Test
	public void setDone() {
	}

	@Test
	public void setCreator() {
	}

	@Test
	public void isOverDue() {
	}

	@Test
	public void getSummary() {
	}
}