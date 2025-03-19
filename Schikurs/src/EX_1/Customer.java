package EX_1;

import JavaUtils.JavaUtils;

public class Customer implements Comparable<Customer> {
    private int customId;
    private String name;
    private Item[] purchase;

    public Customer(String name) {
        this.customId = JavaUtils.random(1000, 9999);
        this.name = name;
        this.purchase = new Item[20];
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, total: %.2f", customId, name, getTotal());
    }

    @Override
    public int compareTo(Customer o) {
        if (o == null) {
            return 0;
        }

        if (this instanceof StoreCustomer && o instanceof OnlineCustomer) {
            return 1;
        } else if (this instanceof OnlineCustomer && o instanceof StoreCustomer) {
            return -1;
        } else if (this instanceof OnlineCustomer && o instanceof OnlineCustomer) {
            return ((OnlineCustomer) this).geteMail().compareTo(((OnlineCustomer) o).geteMail());
        } else {
            return 0;
        }
    }

    public boolean searchItemName(String itemName) {
        for (Item item : purchase) {
            if (item != null) {
                if (item.getDescription().contains(itemName)) {
                    return true;
                }
            }
        }

        return false;
    }

    public double getRawTotal() {
        double total = 0.0;
        for (Item item : purchase) {
            if (item != null) {
                total += item.getPrice();
            }
        }
        return total;
    }

    public double getTotal() {
        double total = getRawTotal();

        if (total > 1000) {
            total *= 0.9;
        }

        return total;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customId) {
        this.customId = customId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item[] getPurchase() {
        return purchase;
    }

    public void setPurchase(Item[] purchase) {
        this.purchase = purchase;
    }
}
