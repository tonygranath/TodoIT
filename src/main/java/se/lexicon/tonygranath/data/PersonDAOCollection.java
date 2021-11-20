package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.Person;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class PersonDAOCollection implements PersonDAO {
    private static PersonDAOCollection INSTANCE;
    private Collection<Person> people = new HashSet<>();

    public PersonDAOCollection(Collection<Person> people) {
        if (people != null)
            this.people = people;
    }

    private PersonDAOCollection() {}

    public static PersonDAOCollection getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PersonDAOCollection();
        return INSTANCE;
    }

    public static PersonDAOCollection getTestInstance() {
        return new PersonDAOCollection();
    }

    @Override
    public Optional<Person> persist(Person person) {
        //I would prefer returning a boolean here...
        people.add(person);
        return Optional.ofNullable(person);
    }

    @Override
    public Collection<Person> findAll() {
        return people;
    }

    @Override
    public boolean remove(Integer id) {
        return people.removeIf(person -> person.getId() == id);
    }

    @Override
    public Optional<Person> findById(int id) {
        return people.stream().filter(person -> person.getId() == id).findFirst();
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        return people.stream().filter(person -> person.getEmail().equalsIgnoreCase(email)).findFirst();
    }
}
