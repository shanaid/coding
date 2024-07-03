
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, allcheck;
	static int sum = -1, bin = 0;
	static int[][] box;
	static boolean[][] vis;

	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Integer> rr = new LinkedList<>();
		Queue<Integer> cc = new LinkedList<>();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		vis = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				int tmp = Integer.parseInt(st.nextToken());

				box[i][k] = tmp;

				if (tmp == 1) {
					rr.offer(i);
					cc.offer(k);
					vis[i][k] = true;
					allcheck++;
					bin++;
				}

				if (tmp == -1) {
					vis[i][k] = true;
					bin++;
				}

			}
		}

		if (allcheck == (N * M)) {
			System.out.println("0");
			return;
		}

		bfs(rr, cc);

//		for(int r= 0; r<N; r++) {
//			for(int c = 0; c<M; c++) {
//				System.out.print(vis[r][c]);
//			}
//			System.out.println();
//		}
		if( bin != ( M*N )) {System.out.println("-1");	return;}
		System.out.println(sum);

	}

	public static void bfs(Queue<Integer> rr, Queue<Integer> cc) {

		if (rr.isEmpty()) {
			return;
		} // 종료문

		sum++; // 한번 도니까

		int time = rr.size();

		for (int q = 0; q < time; q++) {
			int r = rr.poll();
			int c = cc.poll();
			
			for (int k = 0; k < 4; k++) {
				if (r + dr[k] < N && c + dc[k] < M && r + dr[k] >= 0 && c + dc[k] >= 0 && !vis[r + dr[k]][c + dc[k]]
						) {
					rr.offer(r + dr[k]);
					cc.offer(c + dc[k]);
					vis[r + dr[k]][c + dc[k]] = true;
					bin++;
				}
			}

		}

		bfs(rr, cc);
	}
}