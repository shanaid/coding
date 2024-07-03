import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map;
	static int N, M;
	static int num = 0;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < M; c++) {
				if (line.charAt(c) == '1') {
					map[r][c] = true;
				}
			}
		}

		dfs(0, 0);

		System.out.println(num);

	}

	public static void dfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		map[x][y] = false;

		while (!q.isEmpty()) {
			int size = q.size();
			num++;

			for (int k = 0; k < size; k++) {
				int it[] = q.poll();
				int xx = it[0];
				int yy = it[1];

				if (xx == N - 1 && yy == M - 1) {
					return;
				}

				for (int i = 0; i < 4; i++) {
					int dx = xx + dr[i];
					int dy = yy + dc[i];

					if (dx >= 0 && dx < N && dy < M && dy >= 0 && map[dx][dy]) {
						q.add(new int[] { dx, dy });
						map[dx][dy] = false;
					}
				}

			}

		}

	}

}
