import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };

	static int M, N, tmp;
	static boolean[][] map;
	static Stack<int[]> sta = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {

			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			tmp = Integer.parseInt(st.nextToken());
			int result = 0;

			map = new boolean[M][N];

			for (int k = 0; k < tmp; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = true;
			}

			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == true) {
						sta.add(new int[] { r, c });
						탐색();
						result++;
					}
				}
			}

			System.out.println(result);
		}
	}

	private static void 탐색() {
		if (sta.isEmpty()) {
			return;
		}

		int[] k = sta.pop();

		int a = k[0]; // x값
		int b = k[1]; // y값

		for (int q = 0; q < 4; q++) {
			int aa = a + dr[q];
			int bb = b + dc[q];
			if (aa < M && aa >= 0 && bb < N && bb >= 0 && map[aa][bb]) {
				sta.add(new int[] { aa, bb });
				map[aa][bb]= false;
			}
		}
		탐색();
	}
}
