
import java.lang.Math;

public class Laba2 {
   public static void main(String[] args) {
    // Zadanie 1
       int a = 15;
       int b = 4;
       float c = a / b;
       double d  = (float)a * 1*Math.exp(-3) + (double)c;
       System.out.println((float)d);

    // zadaine 2
       float f = (float) 128.50;
       int i = (int) f;
       int b1 = (int) (i + f);
       System.out.println((byte)b1);

       // Zadanie 3
       short number = 9;
       char zero = '0';

       int nine = (zero + number);
       nine = (char)nine;
       System.out.println(nine);
       zadanie4();
       zadanie5();
       zadanie6();
       zadanie7();
       zadanie8();

   }
    public static void zadanie4() {
        double d = (short)2.50256e2d;
        char c = (short) 'd';
        short s = (short) 2.22;
        int i = 150000;
        float f = 0.50f;
        double result = f + (i / c) - (d * s) - 500e-3;
        System.out.println("result: " + result);

    }
    public static void zadanie5() {
        long l = 1234_564_890L;
        int x =  0b1000_1100_1010;
        double m =  110_987_654_6299.123_34;
        float f = l++ + 10 + ++x - (float) m;
        l = (long) f / 1000;
        System.out.println(l);
    }
    public static void zadanie6() {
        int a = 50;
        int b = 17;
        double d = (float) a / (float)b;
        System.out.println(d);
    }
    public static void zadanie7() {
        int a = 257;
        int b = 4;
        int c = 3;
        int e = 2;
        double d = (double) (a + b) / c / e;
        System.out.println(d);
    }
    public static void zadanie8() {
        int a = 5;
        int b = 4;
        int c = 3;
        int e = 2;
        double d = a + (double) b / c / e; 
        System.out.println(d);
    }
}
