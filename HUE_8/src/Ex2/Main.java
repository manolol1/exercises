package Ex2;

public class Main {
    public static void main(String[] args) {
        Article a1 = new Article();
        Article a2 = new Article("Banane"); // Preis wird auf 1.0 gesetzt
        Article a3 = new Article("Apfel", 0.60);
        Invoice inv1 = new Invoice(1);
        // Rechnung mit der Rechnungsnummer 1
        inv1.addArticle(new Article("Apfel", 0.70));
        inv1.addArticle(new Article("Apfel", 0.50));
        inv1.cancelArticle(); // letzter Artikel wird wieder gelöscht
        inv1.addArticle(new Article("Käse", 2.70));
        inv1.addArticle(new Article("Apfel", 0.80));
        inv1.addArticle(new Article("Apfel", 0.90));
        inv1.addArticle(new Article("Käse", 3.50));
        inv1.addArticle(new Article("Birne", 1.20));
        inv1.addArticle(new Article("Orange", 0.90));
        inv1.addArticle(new Article("Birne", 0.70));
        inv1.addArticle(new Article("Kiwi", 0.40));
        inv1.addArticle(new Article("Kiwi", 0.50));
        inv1.addArticle(new Article("Birne", 0.70));
        System.out.println(inv1.toString()); // einfache Ausgabe
        inv1.printCompact(); // Kompakte Ausgabe
        inv1.sortPrice();
        System.out.println(inv1.toString()); // Sortieren und einfache Ausgabe
    }
}
