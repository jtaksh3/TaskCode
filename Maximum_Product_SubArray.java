import java.util.*;

public class Maximum_Product_SubArray {

    static long maxProduct(int[] arr, int n) {
        long minVal = arr[0];
        long maxVal = arr[0];

        long maxProduct = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                long temp = maxVal;
                maxVal = minVal;
                minVal = temp;

            }
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            maxProduct = Math.max(maxProduct, maxVal);
        }
        return maxProduct;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(maxProduct(arr, n));
    }
}
