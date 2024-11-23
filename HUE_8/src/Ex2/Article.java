package Ex2;

public class Article {
    private String name;
    private double price;

    public Article() {
        this.name = "nothing";
    }

    public Article(String name) {
        this.name = name;
        this.price = 1.00;
    }

    public Article(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-18s %2.2f€", name, price);
    }

    /**
     * Check if this article (price and name) is equal to another article
     * @param otherArticle Article to compare to
     * @return Equal?
     */
    public boolean equals(Article otherArticle) {
        if (otherArticle == null) return false;
        return this.name.equals(otherArticle.name) && this.price == otherArticle.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
