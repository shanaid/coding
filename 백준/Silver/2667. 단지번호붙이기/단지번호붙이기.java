import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;
	static int c = 2;

	static int cnt;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static List<Integer> li = new ArrayList<>();

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {

			String str = br.readLine();
			char[] cha = str.toCharArray();

//			int[] a = new int[4];
			for (int c = 0; c < N; c++) {
				if (cha[c] == '1')
					map[r][c] = 1;
			}
		}

		//여기까지 입력 끝
		
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					BFS(r,c);
				}
			}
		}
		
		
		
		System.out.println(li.size());
		Collections.sort(li);
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
		
		
		

	}

	public static void BFS(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		
		cnt=1;
		q.offer(a);
		q.offer(b);
		map[a][b] = 0;
		

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			

			for (int i = 0; i < 4; i++) {
				
				int xx = x + dr[i];
				int yy = y + dc[i];

				if (xx >= 0 && xx < N && yy >= 0 && yy < N && map[xx][yy] == 1) {
					map[xx][yy] = 0;

					q.offer(xx);
					q.offer(yy);
					cnt++;
				}

			}

		}
		
		li.add(cnt);
    }
	}