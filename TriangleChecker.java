import java.util.Scanner;

public class TriangleChecker {

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean isCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Area of triangle = 0 means points are collinear
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coordinates for A (x y):");
        int x1 = sc.nextInt(), y1 = sc.nextInt();

        System.out.println("Enter coordinates for B (x y):");
        int x2 = sc.nextInt(), y2 = sc.nextInt();

        System.out.println("Enter coordinates for C (x y):");
        int x3 = sc.nextInt(), y3 = sc.nextInt();

        if (isCollinear(x1, y1, x2, y2, x3, y3)) {
            System.out.println("❌ Points are collinear. Not a triangle.");
            return;
        }

        double ab = distance(x1, y1, x2, y2);
        double bc = distance(x2, y2, x3, y3);
        double ca = distance(x3, y3, x1, y1);

        System.out.println("✔️ Valid Triangle");

        if (Math.abs(ab - bc) < 1e-6 && Math.abs(bc - ca) < 1e-6)
            System.out.println("Type: Equilateral");
        else if (Math.abs(ab - bc) < 1e-6 || Math.abs(bc - ca) < 1e-6 || Math.abs(ca - ab) < 1e-6)
            System.out.println("Type: Isosceles");
        else
            System.out.println("Type: Scalene");
    }
}
