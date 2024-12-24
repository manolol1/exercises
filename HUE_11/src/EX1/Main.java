package EX1;

public class Main {
    public static void main(String[] args) {
        SnailRun snailRun1 = new SnailRun("Perger Schneckenmarathon", 42);
        BettingOffice bettingOffice = new BettingOffice(snailRun1, 2.0);
        //bettingOffice.execute();
        System.out.println();

        SnailRun snailRun2 = new SnailRun("Iron Snail 2016", 100);
        Snail sissi = new Snail("Sissi", 17);
        snailRun2.addSnail(sissi);
        Snail franz = new Snail("Franz", 16);
        snailRun2.addSnail(franz);
//        bettingOffice = new BettingOffice(snailRun2, 1.25);
//        bettingOffice.execute();
//        System.out.println();
//
//        SnailRun snailRun3 = new SnailRun("3. International Schnecken Berglauf", 22);
//        Snail helga = new Snail("Helga", 5);
//        snailRun3.addSnail(helga);
//        Snail knut = new Snail("Knut", 5);
//        snailRun3.addSnail(knut);
//        bettingOffice = new BettingOffice(snailRun3, 2.25);
//        bettingOffice.addBet(new Bet("Player1", "Helga", 50));
//        bettingOffice.addBet(new Bet("Player2", "Helga", 60));
//        bettingOffice.addBet(new Bet("Player3", "Knut", 65));
//        bettingOffice.execute();
//        System.out.println();
//
//        System.out.println(bettingOffice.toString());
    }
}
