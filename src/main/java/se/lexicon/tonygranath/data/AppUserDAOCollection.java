package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.AppUser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class AppUserDAOCollection implements AppUserDAO {
    private static AppUserDAOCollection INSTANCE;
    private Collection<AppUser> appUsers = new HashSet<>();

    public AppUserDAOCollection(Collection<AppUser> users) {
        if (users != null)
            appUsers = users;
    }

    private AppUserDAOCollection() {}

    public static AppUserDAOCollection getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppUserDAOCollection();
        return INSTANCE;
    }

    public static AppUserDAOCollection getTestInstance() {
        return new AppUserDAOCollection();
    }

    @Override
    public Optional<AppUser> persist(AppUser user) {
        if (!appUsers.contains(user) && (user != null))
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
