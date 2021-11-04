package se.lexicon.tonygranath.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppRoleTest {
    private final static AppRole ROLE_USER = AppRole.ROLE_APP_USER;
    private final static AppRole ROLE_ADMIN = AppRole.ROLE_APP_ADMIN;

    @Test
    public void testUser() {
        assertEquals(ROLE_USER, AppRole.ROLE_APP_USER);
    }

    @Test
    public void testAdmin() {
        assertEquals(ROLE_ADMIN, AppRole.ROLE_APP_ADMIN);
    }
}