package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.io.JSONManager;
import se.lexicon.tonygranath.model.TodoItemTask;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {
    private static TodoItemTaskDAOCollection INSTANCE;
    private Collection<TodoItemTask> tasks = new HashSet<>();

    private TodoItemTaskDAOCollection(Collection<TodoItemTask> tasks) {
        if (tasks == null)  {
            File file = new File("resources/json/todoitemtasks.json");
            if (file.exists()) {
                JSONManager jsonManager = JSONManager.getInstance();
                this.tasks = jsonManager.deserializeToCollection(file, this.tasks, TodoItemTask.class);
            }
        } else
            this.tasks = tasks;
    }

    public static TodoItemTaskDAOCollection getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TodoItemTaskDAOCollection(null);
        return INSTANCE;
    }

    public static TodoItemTaskDAOCollection getTestInstance() {
        return new TodoItemTaskDAOCollection(new HashSet<>());
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
       // tasks.stream().filter(task -> task.getAssignee().getId() == personId).forEach(found::add);
        for (TodoItemTask t : tasks) {
            if ((t.getAssignee() != null) && (t.getAssignee().getId() == personId)) {
                found.add(t);
            }
        }
        return found;
    }
}
