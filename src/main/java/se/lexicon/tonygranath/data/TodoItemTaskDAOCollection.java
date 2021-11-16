package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.TodoItemTask;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {
    private static final TodoItemTaskDAOCollection INSTANCE;
    private final Collection<TodoItemTask> tasks = new HashSet<>();

    static {
        INSTANCE = new TodoItemTaskDAOCollection();
    }

    private TodoItemTaskDAOCollection() {}

    public static TodoItemTaskDAOCollection getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<TodoItemTask> persist(TodoItemTask todoItemTask) {
        //I would just name the parameter "task"
        tasks.add(todoItemTask);
        return Optional.ofNullable(todoItemTask);
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return tasks;
    }

    @Override
    public boolean remove(Integer id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    @Override
    public Optional<TodoItemTask> findById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        Collection<TodoItemTask> found = new HashSet<>();
        tasks.stream().filter(task -> task.isAssigned() == status).forEach(found::add);
        return found;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        Collection<TodoItemTask> found = new HashSet<>();
        tasks.stream().filter(task -> task.getAssignee().getId() == personId).forEach(found::add);
        return found;
    }
}
