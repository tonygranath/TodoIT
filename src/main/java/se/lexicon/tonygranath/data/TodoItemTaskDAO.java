package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.TodoItemTask;

import java.util.Collection;
import java.util.Optional;

public interface TodoItemTaskDAO extends GenericCRUD<TodoItemTask, Integer> {
    Optional<TodoItemTask> findById(int id);
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonId(int personId);
}
