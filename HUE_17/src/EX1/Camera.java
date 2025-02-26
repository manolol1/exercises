package EX1;

import java.util.Arrays;

public class Camera extends Article {
    String supplier;

    public Camera(String supplier, int code, int price) {
        super(code, price);
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return String.format("{tracks: %s; %s}", supplier, super.toString());
    }

    @Override
    public boolean available() {
        return Math.random() < 0.3;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
