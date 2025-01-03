package EX2;

public class ReceiptItem {
    private String productName;
    private int quantity;
    private int priceInCent;
    private int tax;

    public ReceiptItem(String productName, int quantity, int price, int tax) {
        this.productName = productName;
        this.quantity = quantity;
        this.priceInCent = price;
        this.tax = tax;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-" + (Receipt.MAX_LINELENGTH / 2) + "s" , productName));
        String price = String.format("%.2f", priceInCent/100.0);
        sb.append(quantity).append('x').append(price);
        String sum = String.format("%.2f", getSum() / 100.0);
        int spaces = Receipt.MAX_LINELENGTH - Receipt.MAX_LINELENGTH / 2 - String.valueOf(quantity).length() - 1 - price.length() - sum.length();
        sb.append(new String(new char[spaces]).replace("\0", " "));
        sb.append(sum);
        return sb.toString();
    }

    /**
     * Compares two ReceiptItems by their priceInCent, productName and tax (not by quantity)
     * @param item the ReceiptItem to compare with
     * @return true if the ReceiptItems are equal, false otherwise
     */
    public boolean equals(ReceiptItem item) {
        return this.priceInCent == item.priceInCent && this.productName.equals(item.productName) && this.tax == item.tax;
    }

    /**
     * Returns the sum of the ReceiptItem in cents
     * @return the sum of the ReceiptItem in cents
     */
    public int getSum() {
        return quantity * priceInCent;
    }

    /**
     * Adds the quantity of the given ReceiptItem to the quantity of this ReceiptItem
     * @param item the ReceiptItem to add the quantity of
     */
    public void addQuantity(ReceiptItem item) {
        quantity += item.quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPriceInCent() {
        return priceInCent;
    }

    public double getPrice() {
        return priceInCent / 100.0;
    }

    public int getTax() {
        return tax;
    }
}
