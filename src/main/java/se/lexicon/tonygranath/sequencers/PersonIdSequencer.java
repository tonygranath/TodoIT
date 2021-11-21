package se.lexicon.tonygranath.sequencers;

import se.lexicon.tonygranath.io.PropertiesManager;

public class PersonIdSequencer {
    private static PersonIdSequencer INSTANCE;
    private static int currentId = 0;

 /*   private PersonIdSequencer(int currentId) {
        if (currentId == -1) {
            PropertiesManager props = PropertiesManager.getInstance();
            props.read("resources/settings.cfg");
            if (props.get("seq.person") != null)
                setCurrentId(Integer.parseInt(props.get("seq.person")));
        }
    }*/

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
