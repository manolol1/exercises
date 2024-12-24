package EX1;

public class Bet {
    String player;
    String snail;
    double amount;

    /**
     * Create a new Bet
     * @param player Name of the player
     * @param snail Name of the snail
     * @param amount Amount of money to bet
     */
    public Bet(String player, String snail, double amount) {
        this.player = player;
        this.snail = snail;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %.2f}", player, snail, amount);
    }
}
