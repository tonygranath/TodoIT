package se.lexicon.tonygranath.sequencers;

public class TodoItemIdSequencer {
    private static TodoItemIdSequencer INSTANCE;
    private static int currentId;

    private TodoItemIdSequencer() {}

    public static TodoItemIdSequencer getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TodoItemIdSequencer();
        return INSTANCE;
    }

    public static TodoItemIdSequencer getTestInstance() {
        return new TodoItemIdSequencer();
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
