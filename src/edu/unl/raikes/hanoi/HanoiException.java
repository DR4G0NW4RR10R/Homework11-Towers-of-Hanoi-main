package edu.unl.raikes.hanoi;

/**
 * Custom error for the Hanoi puzzle.
 * 
 * @author Sierra Sánchez-Soto
 */
public class HanoiException extends Exception {
    /**
     * Calls Exception's constructor.
     * @param m Exception message
     */
    public HanoiException(String m) {
        super(m);
    }
}
