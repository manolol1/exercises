package EX1;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          06.11. 2024
 * HUE:           06
 * EX:            01
 * Description:   Points
 *********************************************/

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(20, 30, "red");
        Point p2 = new Point(30, 35, "blue");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.getDistance(p2));

        Point p3 = new Point(20, 30, "green");
        System.out.println(p3);
        p3.mirrorX();
        p3.mirrorY();
        System.out.println(p3);

        p3.translate(15, -5);
        System.out.println(p3);

        p2.translate(-10, -5);
        p2.setColor("red");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p2.equals(p1));
    }
}
