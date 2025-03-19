package EX_1;

public class StoreCustomer extends Customer {
    private String mainBranch;
    private String address;
    private double loyaltyDiscount;

    private static double totalDiscounts = 0;

    public StoreCustomer(String name, String mainBranch, String address, double loyaltyDiscount) {
        super(name);
        this.mainBranch = mainBranch;
        this.address = address;
        setLoyaltyDiscount(loyaltyDiscount);
    }

    public StoreCustomer(String name, String mainBranch, String address) {
        super(name);
        this.mainBranch = mainBranch;
        this.address = address;
        this.loyaltyDiscount = 1;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", mainBranch: %s, address: %s, loyaltyDiscount: %.2f", mainBranch, address, loyaltyDiscount);
    }

    @Override
    public double getTotal() {
        double total =  super.getTotal() * (loyaltyDiscount / 100);
        totalDiscounts += getRawTotal() - total;
        return total;
    }

    public String getMainBranch() {
        return mainBranch;
    }

    public void setMainBranch(String mainBranch) {
        this.mainBranch = mainBranch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLoyaltyDiscount() {
        return loyaltyDiscount;
    }

    public void setLoyaltyDiscount(double loyaltyDiscount) {
        if (loyaltyDiscount < 0 || loyaltyDiscount > 10) {
            this.loyaltyDiscount = 1;
            System.err.printf("loyaltyDiscount out of bounds for customer %d", getCustomId());
        } else {
            this.loyaltyDiscount = loyaltyDiscount;
        }
    }

    public static double getTotalDiscounts() {
        return totalDiscounts;
    }
}
