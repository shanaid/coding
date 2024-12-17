import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> num = new PriorityQueue();
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int a = 0; a<N; a++){
            num.add(Integer.parseInt(st.nextToken()));
        }
        for(int a =0; a<N;a++){
            deque.add(num.poll());
        }

        int high = deque.pollLast();
        int low = deque.pollFirst();

        int result_high = high;
        int result_low = low;
        int sum = Math.abs(high + low);

        while( !deque.isEmpty() ){

            if( Math.abs(high) < Math.abs(low) ){ //+가 더 크다면
                low = deque.pollFirst();
            }else{ //-가 더 크다면
                high = deque.pollLast();
            }
            if( Math.abs(high + low) < sum){
                result_high = high;
                result_low = low;
                sum = Math.abs(high + low);
            }

        }

        System.out.println(result_low+ " " +result_high);

    }
}
