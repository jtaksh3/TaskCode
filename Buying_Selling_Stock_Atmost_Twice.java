/*PROBLEM STATEMENT : Maximum profit by buying and selling a share at most twice*/

import java.util.Scanner;

public class Buying_Selling_Stock_Atmost_Twice {

    static int maxProfit(int price[], int n) {
        int buy1, profit1, buy2, profit2;
        buy1 = buy2 = Integer.MAX_VALUE;
        profit1 = profit2 = 0;

        for (int i = 0; i < n; i++) {
            buy1 = Math.min(buy1, price[i]);
            profit1 = Math.max(profit1, price[i] - buy1);

            buy2 = Math.min(buy2, price[i] - profit1);
            profit2 = Math.max(profit2, price[i] - buy2);
        }
        return profit2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        scan.close();

        System.out.println("Maximum Profit = " + maxProfit(arr, n));
    }
}
