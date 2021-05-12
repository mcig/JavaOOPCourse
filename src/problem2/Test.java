package problem2;

public class Test {
    public static void main(String[] args) {
        double x1 = 10.3, x2 = 5.444, y1 = 123.98, y2 = 33.88, z1 = 4.6, z2 = 88.2;
        System.out.println("Distance between points: " + x1 + "; " + x2 + " is: " + Distance.euclideanDistance(x1, x2));
        System.out.println("Distance between points: " + x1 + ", " + x2 + "; " + y1 + ", " + y2 + " is: " + Distance.euclideanDistance(x1, x2, y1, y2));
        System.out.println("Distance between points: " + x1 + ", " + x2 + "; " + y1 + ", " + y2 + "; " + z1 + ", " + z2 + " is: " + Distance.euclideanDistance(x1, x2, y1, y2, z1, z2));
    }
}
