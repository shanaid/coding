import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        class Road {
            int des; // 목적지
            int value; // 가중치
            boolean way; //길인지 터널인지
            Road(int d, int v,boolean w){
                this.des = d;
                this.value = v;
                this.way = w;
            }

        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        start: for(int t = 0; t<TC; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //노드수
            int M = Integer.parseInt(st.nextToken()); // 길
            int W = Integer.parseInt(st.nextToken()); // 웜홀

            ArrayList<ArrayList<Road>> load = new ArrayList<>();

            for(int l = 0; l<= N; l++){ // 0번을 고려해서 이렇게 만듦
                load.add(new ArrayList<>());
            }

            for(int m = 0; m < M; m++){ //길
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                load.get(S).add(new Road(E,T,true));
                load.get(E).add(new Road(S,T,true));
            }


            for(int w = 0; w < W; w++){ //터널
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                load.get(S).add(new Road(E,T,false));
            }

            int dp[] = new int[N+1];
            Arrays.fill(dp,1000000);
            dp[1] = 0;
            for(int i = 1; i<N; i++){ //노드 -1 만큼

                for(int n = 1; n<= N; n++){ //노드 기준으로

                    for(Road r : load.get(n)){ //모든 노드 조사
                       if(r.way){ //길이야
                           dp[r.des] = Math.min(dp[r.des],dp[n]+r.value);
                       }else{
                           dp[r.des]  = Math.min(dp[r.des],dp[n]+(-1*r.value));
                       }
                    }

                }

            }

            int check[] = new int [N+1];
            for(int a = 0; a<=N; a++){
                check[a] = dp[a];
            }

            for(int n = 1; n<= N; n++){ //노드 기준으로

                for(Road r : load.get(n)){ //모든 노드 조사
                    if(r.way){ //길이야
                        dp[r.des] = Math.min(dp[r.des],dp[n]+r.value);
                    }else{
                        dp[r.des]  = Math.min(dp[r.des],dp[n]+(-1*r.value));
                    }
                }

            }

            for(int a = 0; a<=N; a++){
                if(dp[a] != check[a]){
                    System.out.println("YES");
                    continue start;
                }
            }

            System.out.println("NO");
        }
    }
}
