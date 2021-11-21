package se.lexicon.tonygranath.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tonygranath.io.JSONManager;
import se.lexicon.tonygranath.model.Person;
import se.lexicon.tonygranath.model.TodoItem;

import java.io.File;
import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.*;

public class TodoItemDAOCollectionTest {
    JSONManager j = JSONManager.getInstance();
    private final Collection<Person> people = j.deserializeToCollection(new File(PERSONS_FILE), null, Person.class);
    private TodoItemDAOCollection items;
    private static final String PERSONS_FILE = "resources/json/persons.json";
    private final TodoItem item1 = new TodoItem(
            1,
            "TITLE 1",
            "DESCRIPTION 1",
            LocalDate.parse("2022-01-01"),
            false,
            people.stream().filter(p -> p.getId() == 1).findFirst().get()
    );
    private final TodoItem item2 = new TodoItem(
            2,
            "TITLE 2",
            "DESCRIPTION 2",
            LocalDate.parse("2024-04-02"),
            false,
            people.stream().filter(p -> p.getId() == 1).findFirst().get()
    );
    private final TodoItem item3 = new TodoItem(
            3,
            "TITLE 3",
            "DESCRIPTION 3",
            LocalDate.parse("2019-01-02"),
            true,
            people.stream().filter(p -> p.getId() == 2).findFirst().get()
    );

    @Before
    public void setUp() {
        items = TodoItemDAOCollection.getTestInstance();
        items.persist(item1);
        items.persist(item2);
       // items.persist(item3);
       // JSONManager j = JSONManager.getInstance();
       // j.serializeCollection(new File("resources/json/todoitems.json"), items.findAll());

    }

    @Test
    public void persist() {
        items.persist(item3);
        assertTrue(items.findAll().contains(item3));
    }

    @Test
    public void persist_cant_add_duplicates() {
        assertEquals(items.findAll().size(), 2);
        items.persist(item1);
        items.persist(item1);
        assertEquals(items.findAll().size(), 2);
    }

    @Test
    public void persist_cant_add_null_items() {
        assertEquals(items.findAll().size(), 2);
        items.persist(null);
        assertEquals(items.findAll().size(), 2);
    }

    @Test
    public void findAll() {
        assertEquals(items.findAll().size(), 2);
        assertTrue(items.findAll().contains(item1));
        assertTrue(items.findAll().contains(item2));
    }

    @Test
    public void remove() {
        items.persist(item3);
        assertEquals(items.findAll().size(), 3);
        items.remove(item3.getId());
        assertEquals(items.findAll().size(), 2);
    }

    @Test
    public void findById() {
        assertEquals(items.findById(1).get(), item1);
    }

    @Test
    public void findByDoneStatus() {
        items.persist(item3);
        assertEquals(items.findByDoneStatus(false).size(), 2);
        assertEquals(items.findByDoneStatus(true).size(), 1);
    }

    @Test
    public void findByTitleContains() {
        assertEquals(items.findByTitleContains("TITLE").size(), 2);
        assertEquals(items.findByTitleContains("1").size(), 1);
    }

    @Test
    public void findByPersonId() {
        items.persist(item3);
        assertEquals(items.findByPersonId(1).size(), 2);
        assertEquals(items.findByPersonId(2).size(), 1);
    }

    @Test
    public void findByDeadlineBefore() {
        items.persist(item3);
        assertEquals(2, items.findByDeadlineBefore(LocalDate.parse("2024-01-01")).size());
        assertEquals(0, items.findByDeadlineBefore(LocalDate.parse("1980-01-01")).size());
    }

    @Test
    public void findByDeadlineAfter() {
        items.persist(item3);
        assertEquals(1, items.findByDeadlineAfter(LocalDate.parse("2024-01-01")).size());
        assertEquals(0, items.findByDeadlineAfter(LocalDate.parse("2100-01-01")).size());
    }
}