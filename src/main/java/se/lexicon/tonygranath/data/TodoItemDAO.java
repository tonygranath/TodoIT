package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface TodoItemDAO extends GenericCRUD<TodoItem, Integer> {
    Optional<TodoItem> findById(int id);
    Collection<TodoItem> findByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findByDeadlineAfter(LocalDate date);
}
