/*PROBLEM STATEMENT : Implement next permutation, which rearranges numbers into the lexicographically
next greater permutation of numbers.If such an arrangement is not possible, it must rearrange it as the
lowest possible order (i.e., sorted in ascending order).The replacement must be in place and use only
constant extra memory.*/

import java.util.Scanner;

public class Next_Permutation {

    static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

     static private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Size of Array");
        int n = scan.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter Elements of Array");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        nextPermutation(arr);
        for(int i : arr)
            System.out.print(i + " ");
    }
    
}
