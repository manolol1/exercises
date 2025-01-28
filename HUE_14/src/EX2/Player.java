package EX2;

public class Player {
    int backNumber;
    String name;
    PlayerType playerType;
    int price;

    public enum PlayerType {
        GOALKEEPER, DEFENDER, MIDFIELDER, STRIKER
    }

    public Player(String name, int price, PlayerType playerType, int backNumber) {
        this.name = name;
        this.price = price;
        this.playerType = playerType;
        this.backNumber = backNumber;
    }

    public Player(String name, PlayerType playerType, int backNumber) {
        this.name = name;
        this.playerType = playerType;
        this.backNumber = backNumber;
    }

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
    }

    public String toString() {
        return "Name: " + name + ", Price: " + price + ", PlayerType: " + playerType + ", BackNumber: " + backNumber;
    }

    public int getBackNumber() {
        return backNumber;
    }

    /**
     * @param backNumber the backNumber to set (max. 2 digits)
     */
    public void setBackNumber(int backNumber) {
        this.backNumber = backNumber / 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = Math.abs(price);
    }
}
