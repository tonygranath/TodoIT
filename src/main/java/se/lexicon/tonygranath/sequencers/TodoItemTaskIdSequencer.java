package se.lexicon.tonygranath.sequencers;

public class TodoItemTaskIdSequencer  {
    private static final TodoItemTaskIdSequencer INSTANCE;
    private static int currentId;

    static {
        INSTANCE = new TodoItemTaskIdSequencer();
    }

    private TodoItemTaskIdSequencer() {}

    public static TodoItemTaskIdSequencer getInstance() {
        return INSTANCE;
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
