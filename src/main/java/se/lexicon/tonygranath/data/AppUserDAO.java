package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.AppUser;

import java.util.Optional;

public interface AppUserDAO extends GenericCRUD<AppUser, String> {
    Optional<AppUser> findByUsername(String username);
}
