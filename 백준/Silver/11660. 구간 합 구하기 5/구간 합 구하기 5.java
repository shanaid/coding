import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
//        int map[][] = new int [N+1][N+1];
        int dp[][] = new int [N+1][N+1];

        for(int r = 1;r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c =1; c<=N; c++){
                int tmp = Integer.parseInt(st.nextToken());
                for(int x = c; x<=N; x++){
                    dp[r][x] +=tmp;
                }
            }
        }

        for(int t =0; t<M; t++){
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for( int x = x1 ; x <= x2 ; x++ ){
                cnt += ( dp[x][y2] - dp[x][y1-1] );
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
