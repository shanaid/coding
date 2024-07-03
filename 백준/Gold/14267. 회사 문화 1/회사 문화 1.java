import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> com[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()) + 1; // 6드감 5개 데이터
		int M = Integer.parseInt(st.nextToken());

		com = new ArrayList[N]; // 6칸 만듬 0은 비움
		for (int i = 1; i < N; i++) {
			com[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());

		int test = Integer.parseInt(st.nextToken());

		for (int i = 2; i < N; i++) { // 1~5까지 총 5개
			int hal = Integer.parseInt(st.nextToken());
			com[hal].add(i);
		}

		int[] arr = new int[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int good = Integer.parseInt(st.nextToken());
			int many = Integer.parseInt(st.nextToken());

			arr[good] += many;
		}

		plus(arr, 1);

		for (int i = 1; i < N; i++) {
			sb.append(arr[i] + " ");
		}

		System.out.println(sb);
	}

	public static void plus(int[] arr, int n) {
		for (int y : com[n]) {
			arr[y] += arr[n];
			plus(arr,y);
		}
	}

}
