package EX_1;

import JavaUtils.JavaUtils;

public class OnlineCustomer extends Customer {
    private String eMail;
    private double fixDiscount;

    private static double totalDiscounts;

    public OnlineCustomer(String name, String eMail, double fixDiscount) {
        super(name);
        this.eMail = eMail;
        setFixDiscount(fixDiscount);
    }

    public OnlineCustomer(String name, String eMail) {
        super(name);
        this.eMail = eMail;
        this.fixDiscount = 10;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", eMail: %s, fixDiscount: %.2f", eMail, fixDiscount);
    }

    @Override
    public double getTotal() {
        double total = super.getTotal() - fixDiscount;
        totalDiscounts += getRawTotal() - total;
        return total;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public double getFixDiscount() {
        return fixDiscount;
    }

    public void setFixDiscount(double fixDiscount) {
        if (fixDiscount < 10 || fixDiscount > 200) {
            this.fixDiscount = 10;
            System.err.printf("fixDiscount out of bounds for customer %d", getCustomId());
        } else {
            this.fixDiscount = fixDiscount;
        }
    }

    public static double getTotalDiscounts() {
        return totalDiscounts;
    }
}
