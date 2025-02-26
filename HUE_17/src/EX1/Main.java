package EX1;

public class Main {
    public static void main(String[] args) {
        Article[]ar=new Article[10];
        ar[0]=new Book("London","Wolfsblut",1,12);
        ar[1]=new CD(new String[]{"stille nacht","ihr kinderlein kommet","oh du fröhliche"},2,18);
        ar[2]=new CD(new String[]{"Angel","Ghost","All about that bass","Blau blüht der Enzian"},3,28);
        ar[3]=new Book("Zweig","Schachnovelle",4,17);
        ar[4]=new Book("Goethe","Faust",5,23);
        ar[5]=new Camera("Canon",6,255);
        ar[6]=new Camera("Sony",7,499);
        ar[7]=new Book("Brown","Inferno",8,25);
        ar[8]=new Book("Krüger","Java",9,55);
        ar[9]=new Camera("Kodak",10,199);
        // Ausgabe
        System.out.println("Normale Ausgabe");
        printList(ar);
        System.out.println();

        // Sortieren nach Kaufpreis und Ausgabe
        System.out.println("Sortiert nach Kaufpreis");
        sortByPrice(ar);
        printList (ar);
        System.out.println();

        // Sortieren nach Artikelkategorie und Ausgabe
        System.out.println("Sortiert nach Artikelkategorie");
        sortByCategory(ar);
        printList (ar);
        System.out.println();
    }

    public static void printList(Object[] ar) {
        for (Object obj : ar) {
            System.out.println(obj);
        }
    }

    public static void sortByPrice(Article[] ar) {
        int minIndex;
        Article temp;

        for (int i = 0; i < ar.length; i++) {
            minIndex = i;
            for (int j = i; j < ar.length; j++) {
                if (ar[j].getPrice() < ar[minIndex].getPrice()) {
                    minIndex = j;
                }
            }
            temp = ar[minIndex];
            ar[minIndex] = ar[i];
            ar[i] = temp;
        }
    }

    public static void sortByCategory(Article[] ar) {
        int minIndex;
        Article temp;

        for (int i = 0; i < ar.length; i++) {
            minIndex = i;
            for (int j = i; j < ar.length; j++) {
                if (ar[j].getClass().getSimpleName().compareTo(ar[minIndex].getClass().getSimpleName()) < 0) {
                    minIndex = j;
                }
            }
            temp = ar[minIndex];
            ar[minIndex] = ar[i];
            ar[i] = temp;
        }
    }
}
