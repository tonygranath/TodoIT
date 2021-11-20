package se.lexicon.tonygranath.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tonygranath.model.AppRole;
import se.lexicon.tonygranath.model.AppUser;

import static org.junit.Assert.*;

public class AppUserDAOCollectionTest {
    private AppUserDAOCollection users;
    private AppUser user1, user2, user3, user4, user5;

    @Before
    public void setUp() {
        users = AppUserDAOCollection.getTestInstance();
        user1 = new AppUser("user1", "afsff", AppRole.ROLE_APP_USER);
        user2 = new AppUser("user2", "fgewgad", AppRole.ROLE_APP_USER);
        user3 = new AppUser("user3", "rfhs", AppRole.ROLE_APP_USER);
        user4 = new AppUser("admin", "gjesgoiseoig", AppRole.ROLE_APP_ADMIN);
        user5 = new AppUser("user5", "123", AppRole.ROLE_APP_USER);
        users.persist(user1);
        users.persist(user2);
        users.persist(user3);
        users.persist(user4);
    }

    @Test
    public void persist() {
        users.persist(user5);
        assertTrue(users.findByUsername(user5.getUsername()).isPresent());
    }

    @Test
    public void persist_cant_add_duplicate_users() {
        assertEquals(users.findAll().stream().count(), 4);
        users.persist(user1);
        users.persist(user2);
        assertEquals(users.findAll().stream().count(), 4);
    }

    @Test
    public void persist_cant_add_null_user() {
        assertEquals(users.findAll().stream().count(), 4);
        users.persist(null);
        assertEquals(users.findAll().stream().count(), 4);
    }

    @Test
    public void findAll() {
        assertTrue(users.findAll().contains(user1));
        assertTrue(users.findAll().contains(user2));
        assertTrue(users.findAll().contains(user3));
        assertTrue(users.findAll().contains(user4));
        assertEquals(users.findAll().stream().count(), 4);
    }

    @Test
    public void findByUsername() {
        assertTrue(users.findByUsername("user3").isPresent());
    }

    @Test
    public void remove() {
        users.persist(user5);
        users.remove(user5.getUsername());
        assertFalse(users.findByUsername(user5.getUsername()).isPresent());
    }
}