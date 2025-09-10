import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        class hotel{
            int value, people;
            hotel(int v, int p){
                this.value = v;
                this.people = p;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); //목표
        int N = Integer.parseInt(st.nextToken()); //개수
        hotel[] pro = new hotel[N];
        int[] dp = new int[C+100];
        Arrays.fill(dp,10000000);
        dp[0] = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int custum = Integer.parseInt(st.nextToken());
            pro[i] = new hotel(money,custum);
        }

        for(int i = 1; i<= C;i++){ // i는 목표 개수야 목표개수 1개를 채우려면
            for(int q = 0; q<N; q++){
                //여기서 할게 지금 그냥 값을 놓거나
                int money = pro[q].value;
                int cus = pro[q].people;
                if( i-cus < 0){ //계산값이 0보다 작다면
                    dp[i] = Math.min(dp[i],money);

//                    for(int tmp = 1; tmp < cus ;tmp++){
//                        dp[i+tmp] = dp[i];
//                    }

                    //tmp 3명이야 i가 4면 4,5,6,7,8
                }else {
                    dp[i] = Math.min(dp[i], dp[i - cus] + money); //아니면 그 뒤까지 다 채우는 거 하던가

                }
            }

        }
        System.out.println(dp[C]);
//        for(int i = 0; i <= C; i++){
//            System.out.println(dp[i]);
//        }

    }
}
