/*PROBLEM STATEMENT : Given a string S with repeated characters (only lowercase). The task is to rearrange
characters in a string such that no two adjacent characters are same.
Approach 1
*/

import java.io.*;

public class Rearrange_Characters {

    static int rearrangeCharacters(String str, int n) {
        int r = (n / 2) + (n % 2);
        String temp = "";
        for (int i = 0; i < n; i++) {
            if (temp.indexOf(str.charAt(i)) == -1)
                temp += str.charAt(i);
        }
        int arr[] = new int[temp.length()];
        for (int i = 0; i < n; i++) {
            int index = temp.indexOf(str.charAt(i));
            arr[index]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > r)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine().trim();
            System.out.println(rearrangeCharacters(str, str.length()));
        }
    }
}
