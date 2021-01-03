/*PROBLEM STATEMENT : Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that
n > m.*/

import java.util.*;

public class Robin_Karp_Algorithm {

    static int return_hash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += (int) (((str.charAt(i) % 65) * Math.pow(126, str.length() - i - 1)) % Math.pow(2, 31));
        }
        return hash;
    }

    static int return_hash_1(char a, int hash, char b, int length) {
        int hash1 = (int) (((a % 65) * Math.pow(126, length)) % Math.pow(2, 31));
        int hash2 = b % 65;
        return (int) ((((hash - hash1) * 126) + hash2) % Math.pow(2, 31));
    }

    static void rba(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int hashStr2 = return_hash(str2);
        int hashStr1 = 0;

        for (int i = 0; i + m - 1 < n; i++) {
            if (i == 0)
                hashStr1 = return_hash(str1.substring(i, i + m));
            else
                hashStr1 = return_hash_1(str1.charAt(i - 1), hashStr1, str1.charAt(i + m - 1), m - 1);

            if (hashStr1 == hashStr2) {
                if (str1.substring(i, i + m).equals(str2))
                    System.out.print(i + " ");
            }
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        rba(str1, str2);
        scan.close();
    }
}
