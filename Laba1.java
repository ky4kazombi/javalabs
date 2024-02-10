/*
 * Laba1
 */
public class Laba1 {
    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int[] B = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int[] C = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int Asum = sum(A);
        int Bsum = sum(B);
        int Csum = sum(C);
        int result = (Asum + Bsum + Csum) / 2;
        System.out.println(result);
        double R1 = 10;
        double R2 = 20;
        double R3 = 30;
        double I = 5;
        double U = 100;

        calculateVoltages(R1, R2, R3, I, U);
    }
    public static void calculateVoltages(double R1, double R2, double R3, double I, double U) {
        double totalResistance = R1 + R2 + R3;

        double voltage1 = I * R1 / totalResistance * U;
        double voltage2 = I * R2 / totalResistance * U;
        double voltage3 = I * R3 / totalResistance * U;

        System.out.println("Voltage on R1: " + voltage1 + " V");
        System.out.println("Voltage on R2: " + voltage2 + " V");
        System.out.println("Voltage on R3: " + voltage3 + " V");
    }

}
