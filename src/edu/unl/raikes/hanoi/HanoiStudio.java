package edu.unl.raikes.hanoi;

import java.util.ArrayList;

/**
 * The HanoiStudio class handles a tower of Hanoi puzzle, allowing a user to call functions to
 * manipulate the game by moving rings. Enforces rules with a custom error type and prints
 * the gamestate after every move.
 * 
 * @author Sierra Sánchez-Soto
 */
public class HanoiStudio {
    
    private ArrayList<ArrayList<Integer>> pillars = new ArrayList<>();
    private boolean isSolved = false;
    private int highestNumber;
    private int par;
    private int moves;

    /**
     * Constructs a tower of Hanoi puzzle with the specified number of rings.
     * @param rings the number of rings in the initial configuration of the puzzle.
     */
    public HanoiStudio(int rings) {
        this.pillars.add(new ArrayList<>());
        this.pillars.add(new ArrayList<>());
        this.pillars.add(new ArrayList<>());
        this.highestNumber = rings;
        this.moves = 0;
        this.par = (int) Math.pow(2, rings) - 1;

        // populate left pillar with rings
        for (int i = 0; i < rings; i++) {
            this.pillars.get(0).add(i + 1);
        }
    }

    /**
     * Attempts to move a single ring from one pillar to another. Checks for illegal moves.
     * 
     * @param sourcePillar The pillar to take a ring from
     * @param destinationPillar The pillar to move a ring to
     * @param ringNumber The specific ring number to move
     * @return Tue if the operation succeeds. Otherwise, throws an exception
     * @throws HanoiException An exception to indicate an illegal operation was attempted
     */
    public boolean moveRing(int sourcePillar, int destinationPillar, int ringNumber) throws HanoiException {

        //check if the source and destination are the same
        if (sourcePillar == destinationPillar) {
            throw new HanoiException("Cannot move a ring into its own pillar");
        }
        
        //check if the pillar has rings
        if (this.pillars.get(sourcePillar).size() == 0) {
            throw new HanoiException("Cannnot take a ring from pillar " + sourcePillar + " as it is empty.");
        }
        
        int ringToMove = this.pillars.get(sourcePillar).get(0);

        //check if the ring is on top of its column
        if (this.pillars.get(sourcePillar).get(0) != ringNumber) {
            throw new HanoiException(
                "Cannot take ring " + ringNumber + " from pillar "
                + sourcePillar + " because that ring is not on top");
        }
        
        //check if the ring is placable in its new location
        if (this.pillars.get(destinationPillar).size() != 0) {
            if (this.pillars.get(destinationPillar).get(0) <= ringToMove) {
                throw new HanoiException(
                    "Cannot place ring " + ringToMove + " on pillar "
                    + destinationPillar + " because that pillar has a smaller ring on top");
            }
        }

        this.pillars.get(sourcePillar).remove(0);
        this.pillars.get(destinationPillar).add(0, ringToMove);
        this.moves++;

        this.evaluateSolved();

        return true;
    }

    /**
     * Evaluates if the Hanoi puzzle is solved. Stores the result internally.
     */
    private void evaluateSolved() {
        if (this.pillars.get(0).size() == 0 && this.pillars.get(1).size() == 0) {
            this.isSolved = true;
        } else {
            this.isSolved = false;
        }
    }

    /**
     * Dynamically generates a string representative of a Hanoi puzzle with any number of rings in any position.
    */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int padding = this.highestNumber;

        for (int row = 0; row < this.highestNumber + 1; row++) {
            for (int p = 0; p < this.pillars.size(); p++) {
                out.append("   ");
                
                int removedPadding = 0;
                if (this.pillars.get(p).size() >= this.highestNumber + 1 - row) {
                    removedPadding =
                        this.pillars.get(p).get(this.pillars.get(p).size() - (this.highestNumber + 1 - row));
                }

                for (int i = 0; i < (padding - removedPadding); i++) {
                    out.append(" ");
                }

                if (removedPadding == 0) {
                    out.append("|");
                } else {
                    out.append("[");
                    for (int i = 0; i < removedPadding - 1; i++) {
                        out.append("=");
                    }
                    out.append("" + (removedPadding));
                    for (int i = 0; i < removedPadding - 1; i++) {
                        out.append("=");
                    }
                    out.append("]");
                }

                for (int i = 0; i < (padding - removedPadding); i++) {
                    out.append(" ");
                }
            }
            out.append("\n");
        }
        
        for (int p = 0; p < this.pillars.size(); p++) {
            out.append("---");
            for (int i = 0; i < padding; i++) {
                out.append("-");
            }
            out.append("┴");
            for (int i = 0; i < padding; i++) {
                out.append("-");
            }
        }
        out.append("---");
        
        return out.toString();
    }

    /**
     * Getter for a pillar.
     * @param p the pillar to get
     * @return an ArrayList of Integer representing the selected pillar
     */
    public ArrayList<Integer> getPillar(int p) {
        return this.pillars.get(p);
    }

    /**
     * Getter for pillar count.
     * @return how many pillars the puzzle has
     */
    public int getPillarCount() {
        return this.pillars.size();
    }

    /**
     * Getter for moves.
     * @return how many moves have elapsed
     */
    public int getMoves() {
        return this.moves;
    }

    /**
     * Getter for par.
     * @return the par, the minimum number of moves it is possible to solve the puzzle in
     */
    public int getPar() {
        return this.par;
    }

    /**
     * Getter for isSolved.
     * @return whether or not the puzzle is solved
     */
    public boolean isSolved() {
        return this.isSolved;
    }

    /**
     * Getter for ring count.
     * @return the number of rings in the puzzle
     */
    public int getRingCount() {
        return this.highestNumber;
    }
}
