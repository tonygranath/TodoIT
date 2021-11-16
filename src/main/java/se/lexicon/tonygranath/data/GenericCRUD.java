package se.lexicon.tonygranath.data;

import java.util.Collection;
import java.util.Optional;

public interface GenericCRUD<T, ID> {
    Optional<T> persist(T t);
    Collection<T> findAll();
    boolean remove(ID id);
}
