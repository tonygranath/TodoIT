package se.lexicon.tonygranath.sequencers;

public class PersonIdSequencer {
    private static final PersonIdSequencer INSTANCE;
    private static int currentId;

    static {
        INSTANCE = new PersonIdSequencer();
    }

    private PersonIdSequencer() {}

    public static PersonIdSequencer getInstance() {
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
