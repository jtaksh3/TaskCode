/*PROBLEM STATEMENT : Given a string in roman no format (s)  your task is to convert it to an integer .
Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
*/

import java.io.*;

public class Roman_to_Decimal {

    static int checkRoman(char a, int prev) {
        int var = 0;
        switch (a) {
            case 'I':
                var = 1;
                break;
            case 'V':
                var = 5;
                break;
            case 'X':
                var = 10;
                break;
            case 'L':
                var = 50;
                break;
            case 'C':
                var = 100;
                break;
            case 'D':
                var = 500;
                break;
            case 'M':
                var = 1000;
                break;
        }
        return var >= prev ? var : -var;
    }

    static int romanToDecimal(String str) {
        int total = 0, prev = 0, value = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            value = checkRoman(str.charAt(i), prev);
            total += value;
            prev = Math.abs(value);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            System.out.println(romanToDecimal(roman));
        }
    }
}
