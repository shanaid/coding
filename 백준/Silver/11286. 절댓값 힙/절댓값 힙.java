import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int tmp = Integer.compare(Math.abs(o1), Math.abs(o2));
				if (tmp==0) {
					return Integer.compare(o1, o2);
				}
				return tmp;
			}
		});

		int n = Integer.parseInt(br.readLine());

		for (int k = 0; k < n; k++) {
			int s = Integer.parseInt(br.readLine());

			if (s == 0) {
				if (pq.isEmpty()) {
					System.out.println("0");
					continue;
				}
				System.out.println(pq.poll());
			} else {
				pq.offer(s);

			}

		}

	}
}
