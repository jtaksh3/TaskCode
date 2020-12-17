import java.util.*;

public class Count_Pairs_with_Given_Sum {

    static int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 0);
            }
            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hm.get(k - arr[i]) != null) {
                count += hm.get(k - arr[i]);
            }
            if ((k - arr[i]) == arr[i]) {
                count--;
            }
        }
        return (count / 2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = scan.nextInt();
        System.out.print("Enter Sum for Comparison with Pairs: ");
        int k = scan.nextInt();
        // System.out.println("Enter elements of Array:");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(getPairsCount(arr, n, k));
    }

}
