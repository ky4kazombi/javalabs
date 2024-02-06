
import java.lang.Math;

public class Laba2 {
   public static void main(String[] args) {
       int a = 15;
       int b = 4;
       float c = a / b;
       double d  = (float)a * 1*Math.exp(-3) + (double)c;
       System.out.println((float)d);


       float f = (float) 128.50;
       int i = (int) f;
       int b1 = (int) (i + f);
       System.out.println((byte)b1);

       //
       short number = 9;
       char zero = '0';

       int nine = (zero + number);
       nine = (char)nine;
       System.out.println(nine);


       zadanie4();
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

    }
}
