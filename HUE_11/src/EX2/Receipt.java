package EX2;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    static final int MAX_LINELENGTH = 50;
    private Shop shop;
    private String currency;
    private String message;
    private ArrayList<ReceiptItem> items = new ArrayList<>();

    public Receipt(Shop shop, String currency, String message) {
        this.shop = shop;
        this.currency = currency;
        this.message = message;
    }

    /**
     * Adds the given ReceiptItem to the list of items
     * @param item the ReceiptItem to add
     */
    public void addItem(ReceiptItem item) {
        for (ReceiptItem i : items) {
            if (i.equals(item)) {
                i.addQuantity(item);
                return;
            }
        }
        items.add(item);
    }

    /**
     * Removes the given ReceiptItem from the list of items
     * @param item the ReceiptItem to remove
     */
    public void removeItem(ReceiptItem item) {
        items.remove(item);
    }

    /**
     * Removes the ReceiptItem with the given productName from the list of items
     * If an item exists multiple times with different prices or taxes, only the first one is removed.
     * @param productName the name of the ReceiptItem to remove
     */
    public void removeItemByName(String productName) {
        for (ReceiptItem item : items) {
            if (item.getProductName().equals(productName)) {
                items.remove(item);
                System.out.println("Produkt " + productName + " entfernt!");
                return;
            }
        }
    }

    public int getSumTotal() {
        int sumTotal = 0;
        for (ReceiptItem item : items) {
            sumTotal += item.getSum();
        }
        return sumTotal;
    }

    /**
     * Prints the bill with the given moneyInCent
     * @param moneyInCent the money given in cents
     */
    public void bill(int moneyInCent) {
        int sumTotal = getSumTotal();
        int retMoney = moneyInCent - sumTotal;
        if (retMoney < 0) {
            System.out.println("Zu wenig Geld gegeben!");
            return;
        }

        int vatSum10 = 0;
        int vatSum20 = 0;

        for (ReceiptItem item : items) {
            if (item.getTax() == 10) {
                vatSum10 += item.getSum();
            } else if (item.getTax() == 20) {
                vatSum20 += item.getSum();
            }
        }

        //OUTPUT:
        System.out.println(shop);
        System.out.println(String.format("%" + MAX_LINELENGTH + "s", "BETRÄGE IN " + currency));
        String delimitingLine = new String(new char[Receipt.MAX_LINELENGTH]).replace("\0", "-");
        System.out.println(delimitingLine);

        for (ReceiptItem item : items) {
            System.out.println(item);
        }

        System.out.println(delimitingLine);

        System.out.println("GESAMT" + String.format("%" + (MAX_LINELENGTH - 6) + ".2f", sumTotal / 100.0));

        System.out.println(delimitingLine);

        System.out.println(delimitingLine);
        System.out.println();
        System.out.println("GEGEBEN" + String.format("%" + (MAX_LINELENGTH - 7) + ".2f", moneyInCent / 100.0));

        System.out.println("ZURÜCK" + String.format("%" + (MAX_LINELENGTH - 6) + ".2f", retMoney / 100.0));

        System.out.println(delimitingLine);

        if (vatSum10 > 0) {
            System.out.println("MWST: 10%" + String.format("%" + (MAX_LINELENGTH - 9) + ".2f", (vatSum10 / 110.0 * 10.0) / 100));
        }

        if (vatSum20 > 0) {
            System.out.println("MWST: 20%" + String.format("%" + (MAX_LINELENGTH - 9) + ".2f", (vatSum20 / 120.0 * 20.0) / 100));
        }

        System.out.println(delimitingLine);

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("DATUM:" + String.format("%" + (MAX_LINELENGTH - 6) + "s", dateFormat.format(now)));
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        System.out.println("UHRZEIT:" + String.format("%" + (MAX_LINELENGTH - 8) + "s", timeFormat.format(now)));

        System.out.println(delimitingLine);
        System.out.println(message);
        System.out.println(delimitingLine);
    }
}
