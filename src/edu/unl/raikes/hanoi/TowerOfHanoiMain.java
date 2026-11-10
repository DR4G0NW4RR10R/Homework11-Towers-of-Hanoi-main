package edu.unl.raikes.hanoi;

/**
 * 
 * This class  // TODO: FINISH THIS DESCRIPTION.
 *
 * @author Sierra Sánchez-Soto and // TODO: ADD YOUR NAME
 *
 */
public class TowerOfHanoiMain {

    /**
     * Moves a stack of rings from one pillar to another.
     * 
     * @param myHanoi the Hanoi puzzle to solve
     */
    public static void moveStack(HanoiStudio myHanoi, int sourcePillar, int destinationPillar, int depth) {
        // TODO: provide a recursive, loop-free implementation of this function
    }

    /**
     * Solves a Tower of Hanoi puzzle by calling a recursive function that moves stacks of rings.
     * Assumes the provided HanoiStudio is in the inital configuration
     * 
     * @param myHanoi the Hanoi puzzle object to solve
     * @param printTurns whether or not to print the turns to the console
     */
    public static void solvePuzzle(HanoiStudio myHanoi, boolean printTurns) {
        // TODO: provide a loop-free implementation of this function
    }

    /**
     * Initiates, then solves, a Tower of Hanoi puzzle. Checks the validity of the solution
     * and if it was completed in par moves.
     * 
     * @param args this program does not accept command line arguments
     */
    public static void main(String[] args) {
        final int RINGS_TO_SOLVE = 5;
        HanoiStudio myHanoi = new HanoiStudio(RINGS_TO_SOLVE);

        solvePuzzle(myHanoi, false);

        if (myHanoi.isSolved()) {
            System.out.println("Congratulations, you solved the puzzle!");
        } else {
            System.out.println("Oh no, it looks like you didn't solve the puzzle!");
        }
        
        System.out.println("Rings: " + myHanoi.getRingCount());
        System.out.println("Your moves: " + myHanoi.getMoves());
        System.out.println("Par: " + myHanoi.getPar());
    }

}
