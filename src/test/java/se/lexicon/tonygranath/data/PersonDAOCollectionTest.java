package se.lexicon.tonygranath.data;

import org.junit.Before;
import org.junit.Test;

import se.lexicon.tonygranath.model.AppRole;
import se.lexicon.tonygranath.model.AppUser;
import se.lexicon.tonygranath.model.Person;
import se.lexicon.tonygranath.sequencers.PersonIdSequencer;

import java.util.Optional;

import static org.junit.Assert.*;

public class PersonDAOCollectionTest {
    private AppUser testCredentials;
    private Person testPerson1, testPerson2, testPerson3;
    private static final PersonDAOCollection TEST_COLLECTION = PersonDAOCollection.getTestInstance();
    private static final PersonIdSequencer SEQUENCER = PersonIdSequencer.getTestInstance();

    @Before
    public void setUp() {
        SEQUENCER.setCurrentId(0);
        testCredentials = new AppUser("lasse", "123", AppRole.ROLE_APP_USER);
        testPerson1 = new Person(SEQUENCER.nextId(), "Lars", "Ohly", "lars.ohly@vpk.se", testCredentials);
        testPerson2 = new Person(SEQUENCER.nextId(), "Lars", "Leijonborg", "lasse@fp.se", testCredentials);
        testPerson3 = new Person(SEQUENCER.nextId(), "Test", "Testsson", "test@test.se", testCredentials);
        TEST_COLLECTION.persist(testPerson1);
        TEST_COLLECTION.persist(testPerson2);
    }

    @Test
    public void persist() {
        assertEquals(TEST_COLLECTION.persist(testPerson3), Optional.of(testPerson3));
    }

    @Test
    public void findAll() {
        assertTrue(TEST_COLLECTION.findAll().contains(testPerson1));
        assertTrue(TEST_COLLECTION.findAll().contains(testPerson2));
    }

    @Test
    public void remove() {
        assertTrue(TEST_COLLECTION.remove(testPerson1.getId()));
        assertFalse(TEST_COLLECTION.remove(testPerson3.getId()));
    }

    @Test
    public void findById() {
        assertEquals(TEST_COLLECTION.findById(testPerson1.getId()).get(), testPerson1);
        assertEquals(TEST_COLLECTION.findById(testPerson2.getId()).get(), testPerson2);
    }

    @Test
    public void findByEmail() {
        assertEquals(TEST_COLLECTION.findByEmail(testPerson1.getEmail()).get(), testPerson1);
    }
}