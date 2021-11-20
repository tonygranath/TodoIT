package se.lexicon.tonygranath.sequencers;

public class TodoItemTaskIdSequencer  {
    private static TodoItemTaskIdSequencer INSTANCE;
    private static int currentId;

    private TodoItemTaskIdSequencer() {}

    public static TodoItemTaskIdSequencer getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TodoItemTaskIdSequencer();
        return INSTANCE;
    }

    public static TodoItemTaskIdSequencer getTestInstance() {
        return new TodoItemTaskIdSequencer();
    }

    public int nextId() {
        return ++currentId;
    }

    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId(int id) {
        currentId = id;
    }
}
