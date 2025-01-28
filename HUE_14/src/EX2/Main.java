package EX2;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Alex Braun", 1000, Player.PlayerType.MIDFIELDER, 8);
        Player p2 = new Player("Harald Leinmüller", 150000, Player.PlayerType.MIDFIELDER,10);
        Player p3 = new Player("Robert Kastner", 120000, Player.PlayerType.DEFENDER,6);
        Player p4 = new Player("Dominik Raffetseder", 135000, Player.PlayerType.STRIKER,9);
        Player p5 = new Player("Michael Stumpfl", 17500, Player.PlayerType.STRIKER,17);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println();
        Team allStars = new Team("All-Star-Team");
        allStars.addPlayer(new Player("Lionel Messi", 95000000, Player.PlayerType.MIDFIELDER, 10));
        allStars.addPlayer(new Player("Nevio Beneder", 4000, Player.PlayerType.DEFENDER, 2));
        allStars.addPlayer(new Player("Cristiano Ronaldo", 7000000,Player.PlayerType.STRIKER, 7));
        allStars.addPlayer(new Player("Julian Heimel ", 3000,Player.PlayerType. MIDFIELDER, 9));
        allStars.addPlayer(new Player("David Alaba", 60000000,Player.PlayerType.MIDFIELDER, 27));
        allStars.addPlayer(new Player("Yalin Baylan", 3500,Player.PlayerType.GOALKEEPER, 1));
        allStars.addPlayer(new Player("Timo Felbermayr", 3000,Player.PlayerType.STRIKER, 5));
        allStars.addPlayer(new Player("Matthias Hartwagner", 3500,Player.PlayerType.DEFENDER, 3));
        allStars.addPlayer(new Player("Felix Haunschmidt", 3000,Player.PlayerType.STRIKER, 8));
        allStars.addPlayer(new Player("Bulut Ibisler", 3000,Player.PlayerType.DEFENDER, 4));
        allStars.addPlayer(new Player("Hannes Steffelbauer", 4000,Player.PlayerType. MIDFIELDER, 6));
        allStars.addPlayer(new Player("Daniel Steffelbauer", 3000,Player.PlayerType.GOALKEEPER, 13));
        allStars.addPlayer(new Player("Noah Satzinger", 3500,Player.PlayerType.STRIKER, 11));
        System.out.println(allStars);
        allStars.stornoTransfer();
        System.out.println(allStars);
        allStars.sortByPriceDesc();
        System.out.println(allStars);
        allStars.sortByBackNumberAsc();
        System.out.println(allStars);
        System.out.println("Es wurden insgesamt " + Team.TRANSFER_COUNT + " Transfers getätigt.");
        allStars.printTeamByPosition();
    }
}
