import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        here:
        for (int t = 0; t < T; t++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());

            // 배열 입력 처리
            String input = br.readLine(); // "[1,2,3,4]"
            input = input.substring(1, input.length() - 1); // 양쪽 대괄호 제거
            String[] numbers = input.isEmpty() ? new String[0] : input.split(","); // 빈 배열 처리
            int[] card = new int[n];
            for (int i = 0; i < n; i++) {
                card[i] = Integer.parseInt(numbers[i].trim());
            }

            boolean start = true; // 정방향 여부
            int go = 0; // 시작 인덱스
            int back = card.length - 1; // 끝 인덱스

            for (char c : p) {
                if (c == 'R') {
                    start = !start; // 방향 변경
                } else if (c == 'D') {
                    if (go > back) { // card가 비어 있는 경우
                        sb.append("error\n");
                        continue here;
                    }
                    if (start) {
                        go++; // 정방향으로 하나 제거
                    } else {
                        back--; // 역방향으로 하나 제거
                    }
                }
            }

            // 결과 배열 출력
            sb.append("[");
            if (go <= back) {
                if (start) { // 정방향 출력
                    for (int i = go; i < back; i++) {
                        sb.append(card[i]).append(",");
                    }
                    sb.append(card[back]);
                } else { // 역방향 출력
                    for (int i = back; i > go; i--) {
                        sb.append(card[i]).append(",");
                    }
                    sb.append(card[go]);
                }
            }
            sb.append("]\n");
        }

        System.out.print(sb);
    }
}
