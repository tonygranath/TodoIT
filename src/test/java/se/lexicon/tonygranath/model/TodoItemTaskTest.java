package se.lexicon.tonygranath.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TodoItemTaskTest {
	private final int PERSON_ID = 1;
	private final String PERSON_FIRSTNAME = "Jörgen";
	private final String PERSON_LASTNAME = "Svensson";
	private final String PERSON_EMAIL = "test@test.se";
	private Person testPerson;

	private final int TODOITEM_ID = 1;
	private final String TODOITEM_TITLE = "TodoItem Title Test";
	private final String TODOITEM_DESCRIPTION = "TodoItem taskDescription Test";
	private final LocalDate TODOITEM_DEADLINE = LocalDate.parse("2021-01-01");
	private final boolean TODOITEM_DONE = false;
	private TodoItem testItem;

	private final int TODOTASK_ID = 1;
	private final boolean TODOTASK_ASSIGNED = true;
	private TodoItemTask testTask;

	@Before
	public void setUp() {
		testPerson = new Person(PERSON_ID,
				PERSON_FIRSTNAME,
				PERSON_LASTNAME,
				PERSON_EMAIL);
		testItem = new TodoItem(TODOITEM_ID,
				TODOITEM_TITLE,
				TODOITEM_DESCRIPTION,
				TODOITEM_DEADLINE,
				TODOITEM_DONE,
				testPerson);
		testTask = new TodoItemTask(TODOTASK_ID, testItem, testPerson);
	}

	@Test
	public void testTask_successfully_instantiated() {
		assertEquals(TODOTASK_ID, testTask.getId());
		assertTrue(testTask.isAssigned());
	}

	@Test
	public void getId() {
	}

	@Test
	public void isAssigned() {
	}

	@Test
	public void setAssigned() {
	}

	@Test
	public void getTodoItem() {
	}

	@Test
	public void setTodoItem() {
	}

	@Test
	public void getAssignee() {
	}

	@Test
	public void setAssignee() {
	}

	@Test
	public void getSummary() {
	}
}