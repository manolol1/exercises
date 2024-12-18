package EX1;

import java.util.ArrayList;

public class SnailRun {
    String name;
    int maxParticipants;
    ArrayList<Snail> snails;

    /**
     * Create a new SnailRun
     * @param name Name of the snail run
     * @param maxParticipants Maximum amount of participants - if a snail is added to a full run, an Exception is thrown
     */
    public SnailRun(String name, int maxParticipants) {
        this.name = name;
        this.maxParticipants = maxParticipants;
        this.snails = new ArrayList<>();
    }

    /**
     * Add a Snail to the SnailRun.
     * Ideally, every Snail in the SnailRun should have a unique name.
     * @param s Snail to add
     * @throws SnailRunFullException when the SnailRun is already full (no additional snail can be added)
     */
    public void addSnail(Snail s) throws SnailRunFullException {
        if (snails.size() < maxParticipants) {
            snails.add(s);
        } else {
            throw new SnailRunFullException("The SnailRun is already full!");
        }
    }
}
