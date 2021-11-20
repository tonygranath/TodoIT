package se.lexicon.tonygranath.sequencers;

public class PersonIdSequencer {
    private static PersonIdSequencer INSTANCE;
    private static int currentId;

    private PersonIdSequencer() {}

    public static PersonIdSequencer getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PersonIdSequencer();
        return INSTANCE;
    }

    public static PersonIdSequencer getTestInstance() {
        return new PersonIdSequencer();
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
