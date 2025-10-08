import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자: 박예본
 * 이메일: goodyebon123@naver.com
 * 생성일: 25. 10. 8. 오후 5:23
 * 파일명: BJ_16236_아기상어
 */
public class Main{

    static class Space{
        int r,c;
        Space(int r, int c){
           this.r = r;
           this.c = c;
           this.time = 0;
        }

        Space(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.time = t;
        }
        int time;
    }
//    static ArrayList<ArrayList<Space>> list;
    static int[][] map;
    static int N;
    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,1,-1};
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int [N][N];
//        list = new ArrayList<>();
//
//        for(int i =0; i<7; i++){
//            list.add(new ArrayList<>());
//        }
        Space shark = null;
        for(int r =0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c =0; c<N; c++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 9){
                    shark = new Space(r,c);
                }else if(tmp == 0){

                }else{
//                    list.get(tmp).add(new Space(r,c));
                }
                map[r][c] = tmp;
            }
        }
        map[shark.r][shark.c] = 0;
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{shark.r,shark.c,2,0}); //상어 위치, 레벨, 먹은 물고기

        Space willEatFish;
        int result = 0;
        int level = 2;
        int eatenFisth = 0;
        while( (willEatFish = findFish(shark.r,shark.c,level)) != null){
            result+= willEatFish.time;
            map[willEatFish.r][willEatFish.c] = 0;
            eatenFisth ++;
            if( level == eatenFisth){
                level ++;
                eatenFisth = 0;
            }
            shark = new Space(willEatFish.r,willEatFish.c);
        }

        System.out.println(result);
    }


    //찾는거
    public static Space findFish(int r, int c, int level){


        PriorityQueue<Space> pq = new PriorityQueue<>((Space o1, Space o2) -> {
            // 현재 위치를 기준으로 맨해튼 거리를 구하는 상수 'r'과 'c'가 람다 외부에 선언되어 있어야 합니다.

            // 1. 맨해튼 거리 계산 (Distance)
            int dist1 = o1.time;
            int dist2 = o2.time;

            // 2. 거리 비교 (1순위: 거리가 짧은 순서, 오름차순)
            if (dist1 != dist2) {
                return dist1 - dist2; // dist1이 작으면 음수(o1 우선) 반환
            } else {
                // 3. 거리가 같을 경우 행(r) 비교 (2순위: 행이 작은 순서, 오름차순)
                if (o1.r != o2.r) {
                    return o1.r - o2.r; // o1.r이 작으면 음수(o1 우선) 반환
                } else {
                    // 4. 행이 같을 경우 열(c) 비교 (3순위: 열이 작은 순서, 오름차순)
                    return o1.c - o2.c; // o1.c가 작으면 음수(o1 우선) 반환
                }
            }
        });


        Queue<Space> q = new LinkedList<>();

        boolean[][] vis = new boolean[N][N];
        q.add(new Space(r,c,0));
        vis[r][c]= true;

        while(!q.isEmpty()){
            Space now = q.poll();
            for(int i = 0; i<4; i++){
                int nextR = now.r+dr[i];
                int nextC = now.c+dc[i];
                if(nextR < N && nextR >= 0 && nextC < N && nextC >= 0 && !vis[nextR][nextC] && map[nextR][nextC] <= level){
                    vis[nextR][nextC] = true;
                    if(map[nextR][nextC] == 0 || map[nextR][nextC] == level ){
                        //통과
                    }else if(map[nextR][nextC] < level){
                        //먹어
                        pq.add(new Space(nextR,nextC,now.time+1));
                    }else{
                        continue;
                        //못가
                    }
                    q.add(new Space(nextR,nextC,now.time+1));
                }

            }

        }

        if(pq.isEmpty()){ return null;}
        return pq.poll();

    }

}
