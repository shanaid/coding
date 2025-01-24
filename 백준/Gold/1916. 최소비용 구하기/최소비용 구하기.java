import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int start, goal;
    static ArrayList<int[]>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int village = Integer.parseInt(br.readLine()); // 마을 수
        int bus = Integer.parseInt(br.readLine()); // 버스 수
        list = new ArrayList[village + 1]; // 마을이 1부터 시작한다고 가정

        for (int i = 1; i <= village; i++) { // 초기화
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= bus; i++) { // 버스 정보 입력
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[from].add(new int[]{to, val});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); // 출발지
        goal = Integer.parseInt(st.nextToken()); // 목적지

        int[] length = new int[village + 1]; // 최단 거리 배열
        Arrays.fill(length, Integer.MAX_VALUE); // 초기값을 무한대로 설정
        length[start] = 0; // 출발지의 거리는 0

        // 우선순위 큐: (거리, 노드) 쌍을 저장, 거리가 짧은 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, start}); // 시작 노드를 큐에 추가

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentNode = current[1];

            // 현재 노드가 목적지라면 종료
            if (currentNode == goal) {
                break;
            }

            // 현재 노드의 거리가 이미 더 짧다면 스킵
            if (currentDist > length[currentNode]) {
                continue;
            }

            // 현재 노드와 연결된 모든 간선 탐색
            for (int[] edge : list[currentNode]) {
                int nextNode = edge[0];
                int nextDist = currentDist + edge[1];

                // 더 짧은 경로를 발견하면 거리를 업데이트하고 큐에 추가
                if (nextDist < length[nextNode]) {
                    length[nextNode] = nextDist;
                    pq.offer(new int[]{nextDist, nextNode});
                }
            }
        }

        System.out.println(length[goal]); // 목적지까지의 최단 거리 출력
    }
}