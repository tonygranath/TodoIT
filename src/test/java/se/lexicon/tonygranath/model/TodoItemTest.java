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
	private final Person CREATOR = p;
	private TodoItem item;

	@Before
	public void setUp() {
		p = new Person(PERSON_ID, PERSON_FIRSTNAME, PERSON_LASTNAME, PERSON_EMAIL);
		item = new TodoItem(ID, TITLE, DESCRIPTION, DEADLINE, DONE, CREATOR);
	}

	@Test
	public void getId() {
	}

	@Test
	public void getTitle() {
	}

	@Test
	public void setTitle() {
	}

	@Test
	public void getTaskDescription() {
	}

	@Test
	public void setTaskDescription() {
	}

	@Test
	public void getDeadLine() {
	}

	@Test
	public void setDeadLine() {
	}

	@Test
	public void isDone() {
	}

	@Test
	public void setDone() {
	}

	@Test
	public void getCreator() {
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