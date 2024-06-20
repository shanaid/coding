import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer>[] j = new Stack[6];

		for (int i = 0; i < 6; i++) {
			j[i] = new Stack<>();
		}

		int N = sc.nextInt();
		int P = sc.nextInt();

		int cnt = 0;

		for (int i = 0; i < N; i++) {

			int jul = sc.nextInt() - 1;
			int pr = sc.nextInt();

			if (j[jul].isEmpty() || j[jul].peek() < pr) {
				j[jul].push(pr);
				cnt++;
			} else if (j[jul].peek() == pr) {
				continue;
			} else {
				while (!(j[jul].isEmpty()) && j[jul].peek() > pr) {
					j[jul].pop();
					cnt++;
				}
				if (!(j[jul].isEmpty()) && j[jul].peek() == pr) {
					continue;
				}
				j[jul].push(pr);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
