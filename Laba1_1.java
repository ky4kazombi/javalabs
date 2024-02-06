 //
 // TODO Debug shit
 //
import java.lang.Integer;
import static java.lang.Math.min;
import java.util.Scanner;

public class Laba1 {
    public static void main(String[] args) {

    }
    public static void zadaine1(int n) {
        String nstr;
        int nlen = 9999999;
        for (int i = 0; i < n; i++) {
            Scanner scanner = new Scanner(System.in);
            nstr  = scanner.nextLine();
            nlen = Math.min(nlen, nstr.length());

        }
        System.out.println(nstr, nstr.length());
    }

    public static void zadaine2(int n) {
        String strArr = new String[n];
        for (int i = 0; i < n; i++) {
            Scanner scanner = new Scanner(System.in);
            strArr[i] = scanner.nextLine();
        }
        strArr.sort(W, (a, b)->Integer.compare(a.length(), b.length()));

        for (int i = 0; i < n; i++) {
            System.out.println(strArr[i]);
        }
    }
    public static void zadanie3(int n) {

    }
}
