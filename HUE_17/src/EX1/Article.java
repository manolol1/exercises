package EX1;

public abstract class Article {
    private int code;
    private int price;

    public abstract boolean available();

    public Article(int code, int price) {
        this.code = code;
        this.price = price;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("code: %d; price: %d", code, price);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
