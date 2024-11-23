package Ex2;

import java.util.ArrayList;
import java.util.Arrays;

public class Invoice {
    private int id;
    private Article[] articles;

    /**
     * Initialize Invoice with random id
     */
    public Invoice() {
        this.id = (int) (Math.random() * 100);
        articles = new Article[0];
    }

    public Invoice(int id) {
        this.id = id;
        articles = new Article[0];
    }

    /**
     * Add an article to the invoice
     * @param a Article to add
     */
    public void addArticle(Article a) {
        Article[] articlesNew = new Article[articles.length + 1];
        System.arraycopy(articles, 0, articlesNew, 0, articles.length);
        articlesNew[articles.length] = a;
        articles = articlesNew;
    }

    /**
     * Cancel the last article
     */
    public void cancelArticle() {
        if (articles.length == 0) return;
        Article[] articlesNew = new Article[articles.length - 1];
        System.arraycopy(articles, 0, articlesNew, 0, articlesNew.length);
        articles = articlesNew;
    }

    /**
     * Sort articles by price, in ascending order
     */
    public void sortPrice() {
        int min = 0;
        Article temp;

        for (int i = 0; i < articles.length; i++) {
            min = i;
            for (int j = i; j < articles.length; j++) {
                if (articles[j].getPrice() < articles[min].getPrice()) {
                    min = j;
                }
            }
            temp = articles[i];
            articles[i] = articles[min];
            articles[min] = temp;
        }
    }

    /**
     * Calculate total sum of all article prices in the invoice
     * @return sum
     */
    public double getSum() {
        double sum = 0;

        for (Article article : articles) {
            sum += article.getPrice();
        }
        return sum;
    }

    /**
     * Group items with the same name, add their price and print them
     */
    public void printCompact() {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> totalPrices = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (Article article : articles) {
            String name = article.getName();
            double price = article.getPrice();
            int index = names.indexOf(name);

            if (index != -1) {
                totalPrices.set(index, totalPrices.get(index) + price);
                counts.set(index, counts.get(index) + 1);
            } else {
                names.add(name);
                totalPrices.add(price);
                counts.add(1);
            }
        }

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-3s %-18s %2.2f€%n", String.format("%dx", counts.get(i)), names.get(i), totalPrices.get(i));
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Article article : articles) {
            sb.append(article.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
