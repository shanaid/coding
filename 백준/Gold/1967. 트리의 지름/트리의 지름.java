import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<ArrayList<int[]>> tree;  // 트리의 인접 리스트
    static boolean[] visited;  // 방문 여부
    static int maxDist = 0;  // 트리의 지름

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 노드 수
        tree = new ArrayList<>();
        visited = new boolean[N + 1];  // 방문 여부 초기화

        // 트리 초기화
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 트리 간선 입력 받기
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree.get(u).add(new int[]{v, w});  // u -> v 가중치 w
            tree.get(v).add(new int[]{u, w});  // v -> u 가중치 w (무방향 그래프)
        }

        // 첫 번째 DFS: 임의의 노드(1번 노드)에서 가장 먼 노드를 찾는다.
        int[] result1 = dfs(1, 0);
        int farthestNode = result1[0];
        int maxLength = result1[1];

        // 두 번째 DFS: 가장 먼 노드에서 다시 DFS하여 트리의 지름을 찾는다.
        Arrays.fill(visited, false);  // 방문 배열 초기화
        int[] result2 = dfs(farthestNode, 0);

        // 트리의 지름 출력
        System.out.println(result2[1]);
    }

    // DFS 함수 (현재 노드, 현재까지의 거리)
    private static int[] dfs(int node, int dist) {
        visited[node] = true;
        int maxDistance = dist;
        int farthestNode = node;

        // 인접한 노드들 탐색
        for (int[] neighbor : tree.get(node)) {
            int nextNode = neighbor[0];
            int edgeWeight = neighbor[1];

            if (!visited[nextNode]) {
                int[] result = dfs(nextNode, dist + edgeWeight);
                if (result[1] > maxDistance) {
                    maxDistance = result[1];
                    farthestNode = result[0];
                }
            }
        }

        return new int[]{farthestNode, maxDistance};  // 가장 먼 노드와 그 거리를 반환
    }
}
