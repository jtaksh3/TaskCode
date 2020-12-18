import java.util.*;

public class SubArray_sum_Zero {

    static boolean findsum(int arr[], int n) {
        Set<Integer> hs = new HashSet<Integer>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || hs.contains(sum))
                return true;
            hs.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(findsum(arr, n) == true ? "Yes" : "No");
        scan.close();
    }

}
