package EX2;

import java.util.ArrayList;

public class Team {
    static int TRANSFER_COUNT = 0;
    String name;
    ArrayList<Player> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Team: " + name + "\n");
        for (Player player : players) {
            result.append(player).append("\n");
        }
        return result.toString();
    }

    public void addPlayer(Player player) {
        players.add(player);
        TRANSFER_COUNT++;
    }

    public void stornoTransfer() {
        players.remove(players.size() - 1);
        TRANSFER_COUNT--;
    }

    public void sortByPriceDesc() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(i).getPrice() < players.get(j).getPrice()) {
                    Player temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }
    }

    public void sortByBackNumberAsc() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(i).getBackNumber() > players.get(j).getBackNumber()) {
                    Player temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }
    }

    public void printTeamByPosition() {
        System.out.println("\nGOALKEEPER:");
        for (Player player : players) {
            if (player.getPlayerType() == Player.PlayerType.GOALKEEPER) {
                System.out.println(player);
            }
        }

        System.out.println("\nDEFENDER:");
        for (Player player : players) {
            if (player.getPlayerType() == Player.PlayerType.DEFENDER) {
                System.out.println(player);
            }
        }

        System.out.println("\nMIDFIELDER:");
        for (Player player : players) {
            if (player.getPlayerType() == Player.PlayerType.MIDFIELDER) {
                System.out.println(player);
            }
        }

        System.out.println("\nSTRIKER:");
        for (Player player : players) {
            if (player.getPlayerType() == Player.PlayerType.STRIKER) {
                System.out.println(player);
            }
        }
    }

}
