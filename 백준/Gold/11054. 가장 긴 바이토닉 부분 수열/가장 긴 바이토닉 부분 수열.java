import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] plusDp = new int[N];
        int[] minusDp = new int[N];
        Arrays.fill(plusDp,1);
        Arrays.fill(minusDp,1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int a = 0; a < N; a++){
            num[a] = Integer.parseInt(st.nextToken());
        }
        // 들어가는 값이 몇번째로 큰지 알아내는 로직

        for(int a = 0; a<N; a++){
            for(int b = 0; b<a; b++){
                if(num[a] > num[b]){
                    plusDp[a] = Math.max(plusDp[b]+1,plusDp[a]);

                }
            }
        }

        for(int a = N-1; a >=0 ; a--){
            for(int b = N-1; b > a; b--){
                if(num[a] > num[b]){
                    minusDp[a] = Math.max(minusDp[b]+1,minusDp[a]);

                }
            }
        }
        int result = 0;
        for(int i = 0; i<N; i++ ){
            result = Math.max(result,plusDp[i]+minusDp[i]-1);
        }

        System.out.println(result);
    }
}
