package edu.unl.raikes.hanoi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class TowerOfHanoiTest {

    @Test
    public void testBasicPlay() {
        // setup
        HanoiStudio testPuzzle = new HanoiStudio(2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);

        // execute
        TowerOfHanoiMain.moveStack(testPuzzle, 0, 1, 2, 2, false);
        ArrayList<Integer> actual = testPuzzle.getPillar(1);

        // test
        assertEquals("Both rings should be in pillar 2, bu they were not", expected, actual);

        // teardown
        // nothing to tear down!
    }

}
