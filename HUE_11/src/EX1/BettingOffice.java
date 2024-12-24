package EX1;

import java.util.ArrayList;

public class BettingOffice {
    SnailRun snailRun;
    ArrayList<Bet> bets;
    double factor;

    /**
     * Betting Office
     * @param snailRun SnailRun to bet on
     * @param factor Factor to multiply the bet with if the player wins
     * @throws NullPointerException when the SnailRun is null
     */
    public BettingOffice(SnailRun snailRun, double factor) throws NullPointerException {
        if (snailRun != null) {
            this.snailRun = snailRun;
            this.factor = factor;
            bets = new ArrayList<>();
        } else {
            throw new NullPointerException("SnailRun cannot be null");
        }
    }

    /**
     * Add a bet to the betting office
     * @param newBet Bet to add
     * @throws NullPointerException when the bet is null
     */
    public void addBet(Bet newBet) throws NullPointerException {
        if (newBet != null) {
            bets.add(newBet);
        } else {
            throw new NullPointerException("Bet cannot be null");
        }
    }
}
