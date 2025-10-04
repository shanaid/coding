import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        class MovementLine{
            int weight;
            ArrayList<Integer> way;
            public MovementLine(){
                this.weight = Integer.MAX_VALUE;
                this.way = new ArrayList<>();
            }
        }

        class Bus implements Comparable<Bus>{
            int des;
            int weihgt;
            public Bus(int d, int w){
                this.des = d;
                this.weihgt = w;
            }

            public int compareTo(Bus o){
                return this.weihgt - o.weihgt;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Bus>> list = new ArrayList<>();
        for(int i = 0; i<= n; i++){
            list.add(new ArrayList<Bus>());
        }

        for(int b =0; b<m; b++){
            st = new StringTokenizer(br.readLine());
            int sor = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list.get(sor).add(new Bus(des,val));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        MovementLine des[] = new MovementLine[n+1];
        for (int i = 1; i <= n; i++) {
            des[i] = new MovementLine();
        }
        PriorityQueue<Bus> pq = new PriorityQueue<>(); //도착지 X 출발지로 설정

        des[from].weight = 0;
        des[from].way.add(from);

        pq.add(new Bus(from,0)); //d = 출발점

        while (!pq.isEmpty()){

            Bus tmp = pq.poll();
            int start = tmp.des; //출발지 설정

            if( tmp.weihgt != des[start].weight) continue;

            for(int i = 0; i < list.get(start).size(); i++){
                int destina = list.get(start).get(i).des;
                if( tmp.weihgt+list.get(start).get(i).weihgt < des[destina].weight ){
                    des[destina].weight = tmp.weihgt+list.get(start).get(i).weihgt;
                    des[destina].way = new ArrayList<>(des[start].way);
                    des[destina].way.add(destina);
                    pq.add(new Bus(destina,des[destina].weight));
                }
            }

        }

        System.out.println(des[to].weight);
        System.out.println(des[to].way.size());
        for(int o : des[to].way){
            System.out.print(o+" ");
        }


    }




}
