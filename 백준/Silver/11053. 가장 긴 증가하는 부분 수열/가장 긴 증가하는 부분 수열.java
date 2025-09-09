import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자: 박예본
 * 이메일: goodyebon123@naver.com
 * 생성일: 25. 5. 9. 오전 10:21
 * 파일명: 가장긴증가하는부분수열
 */

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 초기화
        Arrays.fill(dp,1);

        // DP
        for(int a = 0; a< N; a++){
           for(int b = 0; b<a; b++){
               if(arr[b]<arr[a]){
                   dp[a] = Math.max(dp[b]+1, dp[a]);
               }
           }
        }
        for(int i = 0; i < N; i++) {
            cnt = Math.max(cnt, dp[i]);
        }

        System.out.print(cnt);

    }
}