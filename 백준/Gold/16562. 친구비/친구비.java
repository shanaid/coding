import java.io.*;
import java.util.*;
public class Main {
    static int N, M, k;
    static int[] price;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //친구수
        M = Integer.parseInt(st.nextToken());   //관계
        k = Integer.parseInt(st.nextToken());   //돈

        price = new int[ N + 1 ]; // 친구비

        st = new StringTokenizer(br.readLine());

        for( int i  = 1; i <= N; i++ ){
            price[i] = Integer.parseInt(st.nextToken());
        }


        for(int l = 0; l < M; l++ ){

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum(a,b);



        }
        int result = 0;

        for(int q = 1; q <= N ; q++ ){
//            System.out.print(price[q]+ " ");
            if( price[q] > 0 ){
                result += price[q];
            }
        }

        if( result <= k){
            System.out.println(result);
        }else{
            System.out.println("Oh no");
        }


    }

    static void sum(int a, int b){
        a = find(a);
        b = find(b);

        if( a == b ) return;

        if( price[a] <= price[b] ){
            price[b] = -a;
        }else{
            price[a] = -b;
        }

    }

    static int find(int i){
        if( 0 < price[i]){
            return i;
        }

        return find(-price[i]);
    }

}
