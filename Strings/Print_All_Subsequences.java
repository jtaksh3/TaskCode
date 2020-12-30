
import java.util.*;

public class Print_All_Subsequences {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		findsubsequences(s, "");
		scan.close();
	}

	private static void findsubsequences(String s, String ans) {
		if (s.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		findsubsequences(s.substring(1), ans);
		findsubsequences(s.substring(1), ans + s.charAt(0));
	}
}
