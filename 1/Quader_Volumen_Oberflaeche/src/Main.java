import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Länge: ");
        double a = s.nextDouble();
        System.out.print("Breite: ");
        double b = s.nextDouble();
        System.out.print("Höhe: ");
        double h = s.nextDouble();

        double volumen = a*b*h;
        double oberflaeche = 2*(a*h + a*b + b*h);

        System.out.println("Volumen = " + volumen + "\nOberfläche = " + oberflaeche);
    }
}