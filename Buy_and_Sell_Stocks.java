import java.util.Scanner;

public class Buy_and_Sell_Stocks {

    static int maxProfit(int[] arr) {
        int n = arr.length, max = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(arr[i] < min) {
                min = arr[i];
            } else if(arr[i] - min > max) {
                max = arr[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = scan.nextInt();
        System.out.println("Enter elements of Array:");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(maxProfit(arr));
    }
    
}
