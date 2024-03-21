/********************************************
* Zusatzklasse
* Aufgabe: EX_20_04_SnailRace
*********************************************/

public class Player {
   private int position = 0;
   private int playerId;
   String fieldBorderTopBottom = "    -";
   
   public Player(int playerId) {
      for (int i = 0; i < Constants.FIELD_SIZE * 1.5 - 1; i++) {
         this.playerId = playerId;
         fieldBorderTopBottom += "--";
      }
   }
   
   public void printField() {
      StringBuilder field = new StringBuilder(Constants.FIELD_SIZE * 4);
      
      field.append(fieldBorderTopBottom + "\n" + playerId + ": |");
      for (int i = 0; i < position; i++) {
         field.append("  |");
      }
      
      field.append("XX|");
      
      
      for (int i = 0; i < Constants.FIELD_SIZE - position - 1; i++) {
         field.append("  |");
      }
      
      field.append("\n" + fieldBorderTopBottom);
      
      System.out.println(field.toString());
   }
   
   public void roll() {
      int roll = randomNum(1, 6);
      if (roll == 3) {
         System.out.println("Zahl: 3");
         if (position < 3) {
            System.out.println("Spieler " + playerId + " geht zum Start zurueck.");
            position = 0;
         } else {
         
            System.out.println("Spieler " + playerId + " geht um 3 Felder zurueck.");
            position -= 3;
         
         }
      } else if (roll == 6) {
         System.out.println("Zahl: 6");
         System.out.println("Spieler " + playerId + " darf erneut wuerfeln.");
         roll = randomNum(1, 6);
         System.out.println("\nNeue Zahl: " + roll);
         System.out.println("Spieler " + playerId + " geht um " + roll + " Felder weiter.");
         position += roll;
      } else {
         System.out.println("Zahl: " + roll);
         System.out.println("Spieler " + playerId + " geht um " + roll + " Felder weiter.");
         position += roll;
      }
      
      if (position >= Constants.FIELD_SIZE) position = Constants.FIELD_SIZE - 1;
   }
   
   public int getPosition() {
      return position;
   }
   
   private static int randomNum(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
}