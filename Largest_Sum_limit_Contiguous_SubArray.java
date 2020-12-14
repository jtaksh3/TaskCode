//PROBLEM STATEMENT : Find the largest sum of given Contiguous Blocks > 0

import java.util.Scanner;

public class Largest_Sum_limit_Contiguous_SubArray {
    static int i = -1;

    static int return_sum(int arr[], int index, int limit) {
        i++;
        if (i == limit || i == arr.length) {
            i = -1;
            return 0;
        }
        return arr[index] + return_sum(arr, ++index, limit);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Size of Array");
        int n = scan.nextInt();
        int arr[] = new int[n], max = 0;
        System.out.println("Enter Elements of Array");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter No. of contiguos elements for Evaluating Maximum Sum");
        int limit = scan.nextInt();
        if (limit < 2 || limit > n) {
            System.out.println("Wrong Limit Entered");
        } else {
            for (int i = 0; i < n + 1 - limit; i++) {
                int value = return_sum(arr, i, limit);
                if (value > max) {
                    max = value;
                }
            }
            System.out.println("Maximum = " + max);
        }
        scan.close();
    }
}
