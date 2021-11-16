package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.AppUser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class AppUserDAOCollection implements AppUserDAO {
    private static final AppUserDAOCollection INSTANCE;
    private final Collection<AppUser> appUsers = new HashSet<>();

    static {
        INSTANCE = new AppUserDAOCollection();
    }

    private AppUserDAOCollection() {}

    public static AppUserDAOCollection getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<AppUser> persist(AppUser user) {
        appUsers.add(user);
        return Optional.ofNullable(user);
    }

    @Override
    public Collection<AppUser> findAll() {
        return appUsers;
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return appUsers.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    @Override
    public boolean remove(String username) {
        return appUsers.removeIf(user -> user.getUsername().equals(username));
    }
}
