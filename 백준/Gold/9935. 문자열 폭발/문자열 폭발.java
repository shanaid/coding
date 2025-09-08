import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // BOJ면 반드시 Main
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        int m = boom.length;

        // 문자 스택 (배열 + top)
        char[] stack = new char[text.length];
        int top = 0;

        for (char c : text) {
            stack[top++] = c; // push

            // 스택 끝이 boom과 같은지 확인
            if (top >= m) {
                boolean ok = true;
                for (int i = 0; i < m; i++) {
                    if (stack[top - m + i] != boom[i]) {
                        ok = false; break;
                    }
                }
                if (ok) {
                    top -= m; // boom 길이만큼 "폭발" (pop m번 대신 포인터만 이동)
                }
            }
        }

        if (top == 0) {
            System.out.print("FRULA");
        } else {
            StringBuilder sb = new StringBuilder(top);
            for (int i = 0; i < top; i++) sb.append(stack[i]);
            System.out.print(sb.toString());
        }
    }
}
