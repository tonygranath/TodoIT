package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.model.TodoItemTask;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {
    private static TodoItemTaskDAOCollection INSTANCE;
    private Collection<TodoItemTask> tasks = new HashSet<>();

    public TodoItemTaskDAOCollection(Collection<TodoItemTask> tasks) {
        if (tasks != null)
            this.tasks = tasks;
    }
    private TodoItemTaskDAOCollection() {}

    public static TodoItemTaskDAOCollection getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TodoItemTaskDAOCollection();
        return INSTANCE;
    }

    public static TodoItemTaskDAOCollection getTestInstance() {
        return new TodoItemTaskDAOCollection();
    }

    @Override
    public Optional<TodoItemTask> persist(TodoItemTask todoItemTask) {
        //I would just name the parameter "task"

        if ((todoItemTask != null) && !tasks.contains(todoItemTask))
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
