import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 원생 수
        int K = Integer.parseInt(st.nextToken()); // 그룹 수
        st = new StringTokenizer(br.readLine());

        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 원생 간 키 차이 계산
        int[] diffs = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diffs[i] = heights[i + 1] - heights[i];
        }

        // 키 차이를 우선순위 큐에 넣음 (내림차순 정렬을 위해 ReverseOrder 사용)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < diffs.length; i++) {
            pq.add(new int[]{i, diffs[i]});
        }

        // 가장 큰 (K-1)개의 키 차이를 우선순위 큐에서 꺼내 경계로 설정
        List<Integer> boundaries = new ArrayList<>();
        for (int i = 0; i < K - 1; i++) {
            boundaries.add(pq.poll()[0]); // 인덱스만 저장
        }
        Collections.sort(boundaries); // 경계를 오름차순으로 정렬

        // 그룹별 비용 계산
        int result = 0;
        int start = 0;
        for (int boundary : boundaries) {
            result += heights[boundary] - heights[start]; // 그룹 비용 합산
            start = boundary + 1;
        }
        // 마지막 그룹 비용 처리
        result += heights[N - 1] - heights[start];

        System.out.println(result);
    }
}
