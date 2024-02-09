
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
        int[] A =new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int[] B =new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] C = new int[] {1,2,3,4,5,6,7,8,9,10};
        int Asum = sum(A);
        int Bsum = sum(B);
        int Csum = sum(C);
        int result = (Asum + Bsum + Csum) / 2;
        System.out.println(result);
    }
}
