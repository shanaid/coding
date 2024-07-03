import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] map2;
	static int max = 0;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		
		int maxi = 1;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > maxi) {
					maxi = map[r][c];
				}
			}
		}

		int cnt;

		for (int i = 0; i < maxi; i++) {
			
			cnt = 0;
			
			map2 = new int[N][N];
			
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					if (map[r][c] > i && map2[r][c] != 1) {
						DFS(r, c, i);
						cnt++;
//						System.out.println(i);
					}
				}
			}

			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}

	public static void DFS(int r, int c, int i) {
		
		map2[r][c] = 1; // 방문했음!
		
		for (int k = 0; k < 4; k++) {
			int xx = r + dr[k];
			int yy = c + dc[k];
			if (xx < N && xx >= 0 && yy < N && yy >= 0 && map2[xx][yy] != 1 && map[xx][yy] > i) {
				DFS(xx, yy, i);
			}
		}
	}
	
	
}