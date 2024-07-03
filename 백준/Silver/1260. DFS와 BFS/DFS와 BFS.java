import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static int[][] arr;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visited = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		visited[V] = 1;
		DFS(V);

		visited = new int[N + 1];
		visited[V] = 1;
		System.out.println();
		BFS();

	}

	public static void DFS(int next) {
		System.out.print(next + " ");
		
		for (int i = 1; i < N + 1; i++) {
			if (visited[i] == 1 || arr[next][i] == 0)
				continue;
			
			visited[i] = 1;
			DFS(i);

		}
	}

	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
	
		queue.offer(V);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int i = 1; i < N + 1; i++) {
				if (visited[i] == 1 || arr[node][i] == 0)
					continue;

				visited[i] = 1;
				queue.offer(i);
			}

		}
	}
}
