/*PROBLEM STATEMENT : Given an array of integers nums containing n + 1 integers
where each integer is in the range [1, n] inclusive*/

import java.util.Scanner;

public class Find_Duplicate {

    static void findDuplicate(int[] nums) {
        int n = nums.length, flag = 0;
        for (int i = 0; i < n; i++) {
            int index = nums[i] % n;
            nums[index] += n;
        }
        for (int i = 0; i < n; i++) {
            if ((nums[i] / n) >= 2) {
                System.out.print(i + " ");
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("No Repeating Elements.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = scan.nextInt();
        System.out.println("Enter elements of Array:");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            if (arr[i] > n - 1) {
                System.out.println("Error");
                System.exit(0);
            }
        }
        scan.close();
        findDuplicate(arr);
    }

}
