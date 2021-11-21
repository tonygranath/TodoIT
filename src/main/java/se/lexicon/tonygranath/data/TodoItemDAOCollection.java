package se.lexicon.tonygranath.data;

import se.lexicon.tonygranath.io.JSONManager;
import se.lexicon.tonygranath.model.TodoItem;

import java.io.File;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class TodoItemDAOCollection implements TodoItemDAO {
    private static TodoItemDAOCollection INSTANCE;
    private Collection<TodoItem> items = new HashSet<>();

    private TodoItemDAOCollection(Collection<TodoItem> items) {
        if (items == null) {
            File file = new File("resources/json/todoitems.json");
            if (file.exists()) {
                JSONManager jsonManager = JSONManager.getInstance();
                this.items = jsonManager.deserializeToCollection(file, this.items, TodoItem.class);
            }
        } else
            this.items = items;
    }

    public static TodoItemDAOCollection getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TodoItemDAOCollection(null);
        return INSTANCE;
    }

    public static TodoItemDAOCollection getTestInstance() {
        return new TodoItemDAOCollection(new HashSet<>());
    }

    @Override
    public Optional<TodoItem> persist(TodoItem item) {
        if ((item != null) && !items.contains(item))
            items.add(item);
        return Optional.ofNullable(item);
    }

    @Override
    public Collection<TodoItem> findAll() {
        return items;
    }

    @Override
    public boolean remove(Integer id) {
        return items.removeIf(item -> item.getId() == id);
    }

    @Override
    public Optional<TodoItem> findById(int id) {
        return items.stream().filter(item -> item.getId() == id).findFirst();
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean done) {
        Collection<TodoItem> found = new HashSet<>();
        items.stream().filter(item -> item.isDone() == done).forEach(found::add);
        return found;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        Collection<TodoItem> found = new HashSet<>();
        items.stream().filter(item -> item.getTitle().contains(title)).forEach(found::add);
        return found;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        Collection<TodoItem> found = new HashSet<>();
        items.stream().filter(item -> item.getCreator().getId() == personId).forEach(found::add);
        return found;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        Collection<TodoItem> found = new HashSet<>();
        items.stream().filter(item -> item.getDeadLine().isBefore(date)).forEach(found::add);
        return found;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        Collection<TodoItem> found = new HashSet<>();
        items.stream().filter(item -> item.getDeadLine().isAfter(date)).forEach(found::add);
        return found;
    }
}
