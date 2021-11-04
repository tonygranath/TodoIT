package se.lexicon.tonygranath.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppUserTest {
    private final static String USERNAME = "testuser";
    private final static String PASSWORD = "testpwd";
    private final static AppRole ROLE = AppRole.ROLE_APP_ADMIN;
    private AppUser testUser;

    @Before
    public void setUp() {
        testUser = new AppUser(USERNAME, PASSWORD, ROLE);
    }

    //also tests getters
    @Test
    public void testUser_successfully_instantiated() {
        assertEquals(testUser.getUsername(), USERNAME);
        assertEquals(testUser.getPassword(), PASSWORD);
        assertEquals(testUser.getRole(), ROLE);
    }

    //this also tests setUsername(null)
    @Test(expected = RuntimeException.class)
    public void given_null_username_constructor_throws_runtime_exception() {
        testUser = new AppUser(null, PASSWORD, ROLE);
    }

    //this also tests setPassword(null)
    @Test(expected = RuntimeException.class)
    public void given_null_password_constructor_throws_runtime_exception() {
        testUser = new AppUser(USERNAME, null, ROLE);
    }

    //this also tests setRole(null)
    @Test(expected = RuntimeException.class)
    public void given_null_role_constructor_throws_runtime_exception() {
        testUser = new AppUser(USERNAME, PASSWORD, null);
    }

    @Test
    public void setUsername() {
        final String newUsername = "changed_username";
        testUser.setUsername(newUsername);
        assertEquals(newUsername, testUser.getUsername());
    }

    @Test
    public void setPassword() {
        final String newPassword = "changed_password";
        testUser.setPassword(newPassword);
        assertEquals(newPassword, testUser.getPassword());
    }

    @Test
    public void setRole() {
        final AppRole newRole = AppRole.ROLE_APP_USER;
        testUser.setRole(newRole);
        assertEquals(newRole, testUser.getRole());
    }

    @Test
    public void testEquals() {
        final AppUser test = new AppUser(USERNAME, PASSWORD, ROLE);
        assertTrue(testUser.equals(test));
    }

    @Test
    public void testHashCode() {
        //I don't know how to test this so I just print it out
        System.out.println(testUser.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(testUser.toString(),
                "AppUser{username='" + USERNAME +
                        "', password='" + PASSWORD +
                        "', role=" + ROLE + "}");
    }
}