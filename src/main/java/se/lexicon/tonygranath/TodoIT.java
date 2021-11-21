package se.lexicon.tonygranath;

import se.lexicon.tonygranath.data.*;
import se.lexicon.tonygranath.io.JSONManager;
import se.lexicon.tonygranath.io.PropertiesManager;
import se.lexicon.tonygranath.model.Person;
import se.lexicon.tonygranath.model.TodoItem;
import se.lexicon.tonygranath.model.TodoItemTask;
import se.lexicon.tonygranath.sequencers.PersonIdSequencer;
import se.lexicon.tonygranath.sequencers.TodoItemIdSequencer;
import se.lexicon.tonygranath.sequencers.TodoItemTaskIdSequencer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TodoIT {
    private static final String propertyFile = "resources/settings.cfg";
    public static void main(String[] args) {
        PropertiesManager props = PropertiesManager.getInstance();

        if (Files.exists(Paths.get(propertyFile))) {
            props.read(propertyFile);
            PersonIdSequencer personIdSequencer = PersonIdSequencer.getInstance();
            TodoItemIdSequencer todoItemIdSequencer = TodoItemIdSequencer.getInstance();
            TodoItemTaskIdSequencer todoItemTaskIdSequencer = TodoItemTaskIdSequencer.getInstance();
            personIdSequencer.setCurrentId(Integer.parseInt(props.get("seq.person")));
            todoItemIdSequencer.setCurrentId(Integer.parseInt(props.get("seq.todoitem")));
            todoItemTaskIdSequencer.setCurrentId(Integer.parseInt(props.get("seq.todoitemtask")));
        }

        JSONManager jsonManager = JSONManager.getInstance();
        PersonDAOCollection people = PersonDAOCollection.getInstance();
        TodoItemDAOCollection items = TodoItemDAOCollection.getInstance();
        TodoItemTaskDAOCollection tasks = TodoItemTaskDAOCollection.getInstance();
        AppUserDAOCollection users = AppUserDAOCollection.getInstance();

        props.set("seq.person", String.valueOf(people.findAll().stream().mapToInt(Person::getId).max().getAsInt()));
        props.set("seq.todoitem", String.valueOf(items.findAll().stream().mapToInt(TodoItem::getId).max().getAsInt()));
        props.set("seq.todoitemtask", String.valueOf(tasks.findAll().stream().mapToInt(TodoItemTask::getId).max().getAsInt()));
        props.save(propertyFile);

        jsonManager.serializeCollection(new File("resources/json/persons.json"), people.findAll());
        jsonManager.serializeCollection(new File("resources/json/appusers.json"), users.findAll());
        jsonManager.serializeCollection(new File("resources/json/todoitems.json"), items.findAll());
        jsonManager.serializeCollection(new File("resources/json/todoitemtasks.json"), tasks.findAll());
    }
}
