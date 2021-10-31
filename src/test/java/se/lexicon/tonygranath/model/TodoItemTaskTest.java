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
		assertEquals(testPerson, testTask.getAssignee());
		assertEquals(testItem, testTask.getTodoItem());
	}

	@Test
	public void isAssigned() {
		assertTrue(testTask.isAssigned());
	}

	@Test
	public void setAssigned() {
		assertTrue(testTask.isAssigned());
		testTask.setAssigned(false);
		assertFalse(testTask.isAssigned());
	}

	@Test
	public void getTodoItem() {
		assertEquals(testTask.getTodoItem(), testItem);
	}

	@Test
	public void setTodoItem() {
		final TodoItem item = new TodoItem(2, "TITLE", "DESCRIPTION", LocalDate.parse("1900-01-01"), false, testPerson);
		testTask.setTodoItem(item);
		assertEquals(item, testTask.getTodoItem());
	}

	@Test
	public void setAssignee() {
		final Person p = new Person(2, "Frans", "Fransson", "frans@frasse.se");
		testTask.setAssignee(p);
		assertEquals(p, testTask.getAssignee());
	}

	@Test
	public void getSummary() {
		assertEquals(testTask.getSummary(), "{ id: " + TODOTASK_ID + ",\n" +
				"assigned: " + TODOTASK_ASSIGNED + ",\n" +
				"todoItem: { id: " + TODOITEM_ID + ",\n" +
				"title: " + TODOITEM_TITLE + ",\n" +
				"taskDescription: " + TODOITEM_DESCRIPTION + ",\n" +
				"deadLine: " + TODOITEM_DEADLINE + ",\n" +
				"done: " + TODOITEM_DONE + ",\n" +
				"creator: { id: " + PERSON_ID + ",\n" +
				"firstName: " + PERSON_FIRSTNAME + ",\n" +
				"lastName: " + PERSON_LASTNAME + ",\n" +
				"email: " + PERSON_EMAIL + " } },\n" +
				"assignee: { id: " + PERSON_ID + ",\n" +
				"firstName: " + PERSON_FIRSTNAME + ",\n" +
				"lastName: " + PERSON_LASTNAME + ",\n" +
				"email: " + PERSON_EMAIL + " } }");
	}
}