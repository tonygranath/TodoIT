package se.lexicon.tonygranath.sequencers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoItemTaskIdSequencerTest {
    private static final TodoItemTaskIdSequencer SEQUENCER = TodoItemTaskIdSequencer.getTestInstance();

    @Before
    public void setUp() {
        SEQUENCER.setCurrentId(0);
    }

    @Test
    public void nextId() {
        assertEquals(1, SEQUENCER.nextId());
        assertEquals(2, SEQUENCER.nextId());
        assertEquals(3, SEQUENCER.nextId());
    }

    @Test
    public void getCurrentId() {
        assertEquals(0, SEQUENCER.getCurrentId());
    }

    @Test
    public void setCurrentId() {
        SEQUENCER.setCurrentId(5);
        assertEquals(5, SEQUENCER.getCurrentId());
    }
}