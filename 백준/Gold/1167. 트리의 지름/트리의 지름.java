import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int e;
        int value;
        Node(int e,int v){
            this.e = e;
            this.value = v;
        }
    }

    static ArrayList<ArrayList<Node>> list;
    static boolean[] vis;
    static int max, side;
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i<=V; i++){
            list.add(new ArrayList<>());
        }
        vis = new boolean[V+1];

        for(int i = 1; i <= V; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            while ( to != -1 ){
                int val = Integer.parseInt(st.nextToken());
                list.get(from).add(new Node(to,val));
                to = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        side = -1;
        finMax(1,0);
        vis = new boolean[V+1];
        finMax(side,0);

        System.out.println(max);
    }

    static void finMax(int v, int cnt){
        // 탈출조건
        if(cnt>max){
            max = cnt;
            side = v;
        }

        vis[v] = true;
        //할 일
        for(int t = 0; t < list.get(v).size(); t++){
            Node tmp = list.get(v).get(t);
//            System.out.println(tmp.e+" "+tmp.value);
            if(!vis[tmp.e]){ finMax(tmp.e,tmp.value+cnt);}
        }

    }
}
