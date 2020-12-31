import java.io.*;

public class Word_Wrap {

    static void solveWordWrap(int arr[], int n, int k) {
        int i, j, currlen, cost, dp[] = new int[n], ans[] = new int[n];

        dp[n - 1] = 0;
        ans[n - 1] = n - 1;

        for (i = n - 2; i >= 0; i--) {
            currlen = -1;
            dp[i] = Integer.MAX_VALUE;

            for (j = i; j < n; j++) {
                currlen += (arr[j] + 1);

                if (currlen > k)
                    break;
                if (j == n - 1)
                    cost = 0;
                else
                    cost = (k - currlen) * (k - currlen) + dp[j + 1];

                if (cost < dp[i]) {
                    dp[i] = cost;
                    ans[i] = j;
                }
            }
        }

        i = 0;
        while (i < n) {
            System.out.print((i + 1) + " " + (ans[i] + 1) + " ");
            i = ans[i] + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String[] s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);

            int k = Integer.parseInt(br.readLine().trim());
            solveWordWrap(arr, n, k);
            System.out.println();
        }
    }
}
