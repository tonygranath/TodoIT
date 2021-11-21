package se.lexicon.tonygranath.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tonygranath.io.JSONManager;
import se.lexicon.tonygranath.model.Person;
import se.lexicon.tonygranath.model.TodoItem;
import se.lexicon.tonygranath.model.TodoItemTask;

import java.io.File;
import java.util.Collection;

import static org.junit.Assert.*;

public class TodoItemTaskDAOCollectionTest {
    private final JSONManager j = JSONManager.getTestInstance();
    private TodoItemTaskDAOCollection tasks;
    private final Collection<Person> people = j.deserializeToCollection(new File("resources/json/persons.json"), null, Person.class);
    private final Collection<TodoItem> items = j.deserializeToCollection(new File("resources/json/todoitems.json"), null, TodoItem.class);
    private TodoItemTask task1 = new TodoItemTask(1, items.stream().filter(item -> item.getId() == 1).findFirst().get());
    private TodoItemTask task2 = new TodoItemTask(2, items.stream().filter(item -> item.getId() == 2).findFirst().get());
    private TodoItemTask task3 = new TodoItemTask(3, items.stream().filter(item -> item.getId() == 3).findFirst().get());

    @Before
    public void setUp() {
        tasks = TodoItemTaskDAOCollection.getTestInstance();
        tasks.persist(task1);
        tasks.persist(task2);
      //  tasks.persist(task3);
      //  JSONManager j = JSONManager.getInstance();
      //  j.serializeCollection(new File("resources/json/todoitemtasks.json"), tasks.findAll());
    }

    @Test
    public void persist() {
        tasks.persist(task3);
        assertTrue(tasks.findAll().contains(task3));
    }

    @Test
    public void findAll() {
        assertEquals(2, tasks.findAll().size());
        assertTrue(tasks.findAll().contains(task1));
        assertTrue(tasks.findAll().contains(task2));
    }

    @Test
    public void remove() {
        tasks.persist(task3);
        assertEquals(3, tasks.findAll().size());
        tasks.remove(task3.getId());
        assertEquals(2, tasks.findAll().size());
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByAssignedStatus() {
    }

    @Test
    public void findByPersonId() {
    }
}