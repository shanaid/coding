import java.util.*;
import java.io.*;

public class Main {
    static int sizeN, result,R,C;
    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    sizeN = (int)Math.pow(2,N);
    findValue(sizeN);
    System.out.println(result);

    }

    private static void findValue(int size) {
        if (size == 1) return;

        if (R < size / 2 && C < size / 2) { // 1사분면
            findValue(size / 2);
        } else if (R < size / 2 && C >= size / 2) { // 2사분면
            C -= size / 2;
            result += size * size / 4;
            findValue(size / 2);
        } else if (R >= size / 2 && C < size / 2) { // 3사분면
            R -= size / 2;
            result += size * size / 4 * 2;
            findValue(size / 2);
        } else { // 4사분면
            R -= size / 2;
            C -= size / 2;
            result += size * size / 4 * 3;
            findValue(size / 2);
        }
    }
}
