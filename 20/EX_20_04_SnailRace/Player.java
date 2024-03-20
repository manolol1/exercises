/********************************************
* Zusatzklasse
* Aufgabe: EX_20_04_SnailRace
*********************************************/

public class Player {
   private int position = 0;
   private int playerId;
   String fieldBorderH = "    -";
   
   public Player(int playerId) {
      for (int i = 0; i < Constants.FIELD_SIZE * 1.5 - 1; i++) {
         this.playerId = playerId;
         fieldBorderH += "--";
      }
   }
   
   public void printField() {
      StringBuilder field = new StringBuilder(Constants.FIELD_SIZE * 4);
      
      field.append(fieldBorderH + "\n" + playerId + ": |");
      for (int i = 0; i < position; i++) {
         field.append("  |");
      }
      
      field.append("XX|");
      
      for (int i = 0; i < Constants.FIELD_SIZE - position - 1; i++) {
         field.append("  |");
      }
      
      field.append("\n" + fieldBorderH);
      
      System.out.println(field.toString());
   }
}