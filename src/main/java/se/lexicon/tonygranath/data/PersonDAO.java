package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.Person;

import java.util.Optional;

public interface PersonDAO extends GenericCRUD<Person, Integer> {
    Optional<Person> findById(int id);
    Optional<Person> findByEmail(String email);
}
