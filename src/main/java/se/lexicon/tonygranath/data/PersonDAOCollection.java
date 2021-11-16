package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.Person;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class PersonDAOCollection implements PersonDAO {
    private static final PersonDAOCollection INSTANCE;
    private final Collection<Person> persons = new HashSet<>();

    static {
        INSTANCE = new PersonDAOCollection();
    }

    public static PersonDAOCollection getInstance() {
        return INSTANCE;
    }

    private PersonDAOCollection() {}

    @Override
    public Optional<Person> persist(Person person) {
        //I would prefer returning a boolean here...
        persons.add(person);
        return Optional.ofNullable(person);
    }

    @Override
    public Collection<Person> findAll() {
        return persons;
    }

    @Override
    public boolean remove(Integer id) {
        return persons.removeIf(person -> person.getId() == id);
    }

    @Override
    public Optional<Person> findById(int id) {
        return persons.stream().filter(person -> person.getId() == id).findFirst();
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        return persons.stream().filter(person -> person.getEmail().equalsIgnoreCase(email)).findFirst();
    }
}
