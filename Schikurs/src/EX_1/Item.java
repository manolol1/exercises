package EX_1;

public class Item {
    private int itemId;
    private String description;
    private double price;

    public Item(int itemId, String description, double price) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
