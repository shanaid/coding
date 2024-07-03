import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int M,N, 현치집;
	static int 전체치킨수 = Integer.MAX_VALUE;
	static int[] 치킨선택;
	
	static List<int[]> 집 = new LinkedList<>();
	static List<int[]> 치킨집 = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	M = Integer.parseInt(st.nextToken());
	N = Integer.parseInt(st.nextToken());
	
	치킨선택 = new int[N];
	
	for(int k = 0; k<M; k++) {
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j<M; j++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp==1) 집.add(new int[] {k,j});
			if(temp==2) 치킨집.add(new int[] {k,j});
		}
	}
	
	
	현치집 = 치킨집.size();
	
	치킨집확인(0,0);
	
	System.out.println(전체치킨수);
	
	}

	private static void 치킨집확인(int 기준, int num) {
		// 다 가보거나(다 차면), N 이상 가본 가능성 제시했거나
		//하면 이제 한번 얼마나 걸리는지 테스트 해보고 최소값을 tmp에 넣는데, 만약 그러다 현재 전체 치킨수를 넘으면
		//그냥 return
		if(num==N) {
			
//			System.out.println(Arrays.toString(치킨선택));
			
			int 총치킨거리 = 0;
			for(int a=0; a<집.size();a++) {
			 
			 int[] 집tmp = 집.get(a); // 집에 대한 정보 얻어옴
//			 int 치킨거리 = 0;			 // 현재 집에 대한 최적 치킨 거리
			 int 임시치킨거리 = Integer.MAX_VALUE; // 임시로 현재와 집과의 치킨거리
			 
			 for(int b=0; b<치킨선택.length;b++) { //치킨집 돌고
				 
				 int[] 치킨tmp = 치킨집.get(치킨선택[b]); //치킨집 정보 받아오고
				 
				  임시치킨거리 = Math.min(임시치킨거리, Math.abs(집tmp[0]-치킨tmp[0])+Math.abs(집tmp[1]-치킨tmp[1])); 
				  //임시 치킨거리에 최소값 넣습니다ㅣ
				  
				  }
			 //정해졌으니 현재집에 대한 치킨 거리 정보 저장 
			총치킨거리+=임시치킨거리;
			 
			 if(총치킨거리 >= 전체치킨수) return;
			}
			
			전체치킨수 = 총치킨거리;
			return;
		}
		
		
		// 선택할 치킨집을 골라서 - for문을 통해 돌린다. 그리고 재귀한다.
		
		for(int i = 기준; i<현치집;i++) {
			치킨선택[num] = i;
		
			치킨집확인(i+1,num+1);
		}
		
	}
	
}
