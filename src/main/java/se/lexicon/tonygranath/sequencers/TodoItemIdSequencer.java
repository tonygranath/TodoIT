package se.lexicon.tonygranath.sequencers;

public class TodoItemIdSequencer {
    private static final TodoItemIdSequencer INSTANCE;
    private static int currentId;

    static {
        INSTANCE = new TodoItemIdSequencer();
    }

    private TodoItemIdSequencer() {}

    public static TodoItemIdSequencer getInstance() {
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
