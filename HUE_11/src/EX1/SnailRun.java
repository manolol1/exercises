package EX1;

import java.util.ArrayList;

public class SnailRun {
    private String name;
    private final int maxParticipants;
    private final ArrayList<Snail> snails;
    private int distance = 100;

    /**
     * Create a new SnailRun with a default distance of 100
     * @param name Name of the snail run
     * @param maxParticipants Maximum amount of participants - if a snail is added to a full run, an Exception is thrown
     */
    public SnailRun(String name, int maxParticipants) {
        this.name = name;
        this.maxParticipants = maxParticipants;
        this.snails = new ArrayList<>();
    }

    /**
     * Create a new SnailRun
     * @param name Name of the snail run
     * @param maxParticipants Maximum amount of participants - if a snail is added to a full run, an Exception is thrown
     * @param distance Distance to run
     */
    public SnailRun(String name, int maxParticipants, int distance) {
        this.name = name;
        this.maxParticipants = maxParticipants;
        this.snails = new ArrayList<>();
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("SnailRun{name='%s', maxParticipants=%d, snails=%s, distance=%d}", name, maxParticipants, snails, distance);
    }

    /**
     * Add a Snail to the SnailRun.
     * Every Snail in the SnailRun must  have a unique name.
     * @param s Snail to add
     * @throws SnailRunFullException when the SnailRun is already full (no additional snail can be added)
     * @throws SnailAlreadyExistsException when a snail with the same name already exists in the SnailRun
     * @throws NullPointerException when the snail is null
     */
    public void addSnail(Snail s) throws SnailRunFullException, SnailAlreadyExistsException, NullPointerException {
        if (snails.size() >= maxParticipants) {
            throw new SnailRunFullException("SnailRun is full");
        }
        else if (s == null) {
            throw new NullPointerException("Snail cannot be null");
        }
        else if (snailExists(s.getName())) {
            throw new SnailAlreadyExistsException("Snail with name " + s.getName() + " already exists in the SnailRun");
        }
        else {
            snails.add(s);
        }
    }

    /**
     * Remove a snail from the SnailRun
     * @param s Snail to remove
     */
    public void removeSnail(Snail s) {
        snails.remove(s);
    }

    /**
     * Remove a snail from the SnailRun
     * @param name Name of the snail to remove
     */
    public void removeSnail(String name) {
        for (Snail s : snails) {
            if (s.getName().equals(name)) {
                snails.remove(s);
                return;
            }
        }
    }

    /**
     * Check if a snail with the given name exists in the snail run
     * @return true if the snail exists, false otherwise
     */
    public boolean snailExists(String name) {
        for (Snail s : snails) {
            if (s.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Let every snail creep once
     */
    public void letThemCreep() {
        for (Snail s : snails) {
            s.creep();
        }
    }

    /**
     * Start the SnailRun and let the snails creep until a winner is found
     */
    public void startRun() {
        if (snails.isEmpty()) {
            return;
        }

        while (getWinner() == null) {
            letThemCreep();
        }
    }

    /**
     * Get the winner of the SnailRun
     * @return the winning snail or null if no snail has reached the finish line
     */
    public Snail getWinner() {
        if (snails.isEmpty()) {
            return null;
        }

        Snail winner = new Snail("winning_condition", 0);
        winner.setDistance(this.distance);
        for (Snail s : snails) {
            if (s.getDistance() > winner.getDistance()) {
                winner = s;
            }
        }
        if (winner.getDistance() > this.distance) {
            return winner;
        } else {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public int getDistance() {
        return distance;
    }
}
