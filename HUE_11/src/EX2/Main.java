package EX2;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("HTL Schulbuffet", "Machlandstraße", 48, 4320, "Perg", "07262/555 0815", "schulbuffet@htl-perg.ac.at");

        Receipt receipt = new Receipt(shop, "EUR", "Vielen Dank für Ihren Einkauf!");
        receipt.addItem(new ReceiptItem("Cola 0,5l", 1, 120, 10));
        receipt.addItem(new ReceiptItem("Cola 0,5l", 1, 120, 10));
        receipt.addItem(new ReceiptItem("Pizzaeck", 1, 190, 10));
        receipt.addItem(new ReceiptItem("M&Ms 200g", 3, 170, 10));
        receipt.addItem(new ReceiptItem("Leberkassemmel", 1, 270, 10));
        receipt.addItem(new ReceiptItem("Käsekrainer", 1, 280, 20));
        receipt.removeItemByName("Käsekrainer");
        receipt.bill(1500);
    }
}
